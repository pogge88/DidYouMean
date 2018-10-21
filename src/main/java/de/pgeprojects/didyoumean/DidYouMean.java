package de.pgeprojects.didyoumean;

import de.pgeprojects.didyoumean.calculation.Calculator;
import de.pgeprojects.didyoumean.calculation.CalculatorImpl;
import de.pgeprojects.didyoumean.calculation.Result;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;

public class DidYouMean {
    private Calculator calculator;

    private DidYouMean(Calculator calculator) {
        this.calculator = calculator;
    }

    public Optional<Result> find(String word){
        Result result = calculator.calculate(word);
        if(null == result) return Optional.empty();
        return Optional.of(result);
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
