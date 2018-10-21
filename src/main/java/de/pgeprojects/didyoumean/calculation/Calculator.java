package de.pgeprojects.didyoumean.calculation;
import java.util.HashSet;

public interface Calculator {

    void setContainer(HashSet<String> container);
    HashSet getContainer();

    Result calculate(String word);

}
