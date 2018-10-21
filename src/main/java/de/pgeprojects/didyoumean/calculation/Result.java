package de.pgeprojects.didyoumean.calculation;

import java.util.Objects;

public class Result {
    private float percentageDistance;
    private int accurateDistance;
    private String word;

    Result(String word, float percentageDistance, int accurateDistance) {
        this.percentageDistance = percentageDistance;
        this.accurateDistance = accurateDistance;
        this.word = word;
    }

    public float getPercentageDistance() {
        return percentageDistance;
    }

    public void setPercentageDistance(float percentageDistance) {
        this.percentageDistance = percentageDistance;
    }

    public int getAccurateDistance() {
        return accurateDistance;
    }

    public void setAccurateDistance(int accurateDistance) {
        this.accurateDistance = accurateDistance;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return Float.compare(result.percentageDistance, percentageDistance) == 0 &&
                accurateDistance == result.accurateDistance &&
                Objects.equals(word, result.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(percentageDistance, accurateDistance, word);
    }

    @Override
    public String toString() {
        return "Result{" +
                "percentageDistance=" + percentageDistance +
                ", accurateDistance=" + accurateDistance +
                ", word='" + word + '\'' +
                '}';
    }

    public static class ResultBuilder{

        private float nestedPercentage;
        private int nestedAccurate;
        private String nestedWord;

        public ResultBuilder(String word)
        {
            this.nestedWord = word;
        }

        public ResultBuilder distance(int value){
            this.nestedAccurate = value;
            this.nestedPercentage = getPercentage(value, this.nestedWord.length());
            return this;
        }

        public Result build(){
            return new Result(this.nestedWord, this.nestedPercentage, this.nestedAccurate);
        }

        private float getPercentage(int value, int total){
            return (value * 100.0f) / total;
        }
    }
}
