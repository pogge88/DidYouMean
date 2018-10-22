package de.pgeprojects.didyoumean.calculation;

import de.pgeprojects.didyoumean.Sentence;
import de.pgeprojects.didyoumean.Word;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class CalculatorImpl implements Calculator {

    private int defaultDistance = 1;
    private HashSet<String> container;

    @Override
    public void setDefaultDistance(int distance) {
        this.defaultDistance = distance;
    }

    @Override
    public void setContainer(HashSet<String> container) {
        this.container = container;
    }

    @Override
    public HashSet getContainer() {
        return this.container;
    }

    @Override
    public Word word(String subject) {
        int currentDistance = Integer.MAX_VALUE;
        if(0 == this.container.size()) throw new UnsupportedOperationException();
        Word result = new Word.WordBuilder(subject, subject).distance(0).build();
        for (String word: this.container) {
            if(subject.equals(word)) return new Word.WordBuilder(word, subject).distance(0).build();

            int distance = getDifference(subject, word);
            if(distance < currentDistance && distance <= defaultDistance)
            {
                result = new Word.WordBuilder(word, subject).distance(distance).build();
                currentDistance = distance;
            }
        }
        return result;
    }

    @Override
    public Sentence sentence(String sentence) {
        sentence = sentence.trim();
        List<String> parts = Arrays.stream(sentence.split(" "))
                .filter(w -> !w.matches(".*\\d+.*"))
                .map(w -> w.replaceAll("[^A-Za-z]","" ))
                .collect(Collectors.toList());

        List<Word> words = parts.stream().map(this::word).collect(Collectors.toList());
        return new Sentence(words, sentence);
    }

    private int getDifference(String x, String y){
        if(null == x || null == y) throw new IllegalArgumentException();

        if(x.isEmpty()) return y.length();
        if(y.isEmpty()) return x.length();

        int substitution = getDifference(x.substring(1), y.substring(1))
                + costOfSubstitution(x.charAt(0), y.charAt(0));

        int insertion = getDifference(x, y.substring(1)) + 1;
        int deletion = getDifference(x.substring(1),y) + 1;

        return min(substitution, insertion, deletion);
    }

    private int costOfSubstitution(char a, char b){
        return a == b ? 0 : 1;
    }

    private int min(int... numbers){
        return Arrays.stream(numbers).min().orElse(Integer.MAX_VALUE);
    }
}
