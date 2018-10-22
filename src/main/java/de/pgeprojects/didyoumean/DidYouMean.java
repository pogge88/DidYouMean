package de.pgeprojects.didyoumean;

import de.pgeprojects.didyoumean.calculation.Calculator;
import de.pgeprojects.didyoumean.calculation.CalculatorImpl;

import java.util.Collection;
import java.util.HashSet;

public class DidYouMean {
    private Calculator calculator;

    private DidYouMean(Calculator calculator) {
        this.calculator = calculator;
    }

    public Word word(String word){
        return calculator.word(word);
    }

    public Sentence sentence(String sentence){
        return calculator.sentence(sentence);
    }

    public static class Builder{
        private Calculator nestedCalculator;

        public Builder(Collection<String> data) {
            this.nestedCalculator = new CalculatorImpl();
            this.nestedCalculator.setContainer(new HashSet<>(data));
        }

        public Builder calculator(Calculator calculator){
            HashSet container = this.nestedCalculator.getContainer();
            this.nestedCalculator = calculator;
            this.nestedCalculator.setContainer(container);

            return this;
        }

        public DidYouMean build(){
            return new DidYouMean(this.nestedCalculator);
        }
    }
}
