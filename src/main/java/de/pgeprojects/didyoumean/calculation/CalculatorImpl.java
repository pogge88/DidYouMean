package de.pgeprojects.didyoumean.calculation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;

public class CalculatorImpl implements Calculator {

    private HashSet<String> container;

    @Override
    public void setContainer(HashSet<String> container) {
        this.container = container;
    }

    @Override
    public HashSet getContainer() {
        return this.container;
    }

    @Override
    public Result calculate(String subject) {
        int currentDistance = Integer.MAX_VALUE;
        if(0 == this.container.size()) throw new UnsupportedOperationException();
        Result result = null;
        for (String word: this.container) {
            if(subject.equals(word)) return new Result.ResultBuilder(word).distance(0).build();

            int distance = getDifference(subject, word);
            if(distance < currentDistance)
            {
                result = new Result.ResultBuilder(word).distance(distance).build();
                currentDistance = distance;
            }
        }
        return result;
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
