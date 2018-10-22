package de.pgeprojects.didyoumean.calculation;
import de.pgeprojects.didyoumean.Sentence;
import de.pgeprojects.didyoumean.Word;

import java.util.HashSet;

public interface Calculator {

    void setDefaultDistance(int distance);


    void setContainer(HashSet<String> container);
    HashSet getContainer();

    Word word(String word);

    Sentence sentence(String sentence);
}
