package de.pgeprojects.didyoumean;

import java.util.Collection;
import java.util.Objects;

public class Sentence{

    private Collection<Word> words;

    private String content;
    private String origin;

    public Sentence(Collection<Word> words, String origin) {
        this.words = words;
        this.origin = origin;
        this.repleaceOrigin();
    }

    public Collection<Word> getWords() {
        return words;
    }

    public void setWords(Collection<Word> words) {
        this.words = words;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    private void repleaceOrigin(){
        content = origin;
        for (Word word: this.words) {
            content = content.replace(word.getOrigin(), word.getContent());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sentence sentence = (Sentence) o;
        return Objects.equals(words, sentence.words) &&
                Objects.equals(content, sentence.content) &&
                Objects.equals(origin, sentence.origin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(words, content, origin);
    }

    @Override
    public String toString() {
        return content;
    }
}
