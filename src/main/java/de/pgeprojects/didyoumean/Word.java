package de.pgeprojects.didyoumean;

import java.util.Objects;

public class Word {

    private String content;
    private String origin;
    private int distance;
    private float percentage;

    private Word(String content, String origin, int distance, float percentage) {
        this.content = content;
        this.origin = origin;
        this.distance = distance;
        this.percentage = percentage;
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

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return distance == word.distance &&
                percentage == word.percentage &&
                Objects.equals(content, word.content) &&
                Objects.equals(origin, word.origin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content, origin, distance, percentage);
    }

    @Override
    public String toString() {
        return content;
    }

    public static class WordBuilder{

        private String content;
        private String origin;
        private int distance;
        private float percentage;

        public WordBuilder(String content, String origin) {
            this.content = content;
            this.origin = origin;
        }

        public WordBuilder distance(int distance){
            this.distance = distance;
            this.percentage = (float) distance / this.content.length();
            this.percentage *= 100;

            return this;
        }

        public Word build(){
            return new Word(content, origin, distance, percentage);
        }
    }
}
