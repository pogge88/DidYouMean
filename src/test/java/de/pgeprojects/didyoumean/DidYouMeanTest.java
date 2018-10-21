package de.pgeprojects.didyoumean;

import de.pgeprojects.didyoumean.calculation.Result;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;

public class DidYouMeanTest {

    private HashSet<String> words;
    private DidYouMean subject;

    @BeforeEach
    public void setUp(){
        this.words = new HashSet<>();
        this.words.addAll(Arrays.asList("Hammer","Motor","Schrauben","Test"));

        this.subject = new DidYouMean.Builder(this.words).build();
    }

    @Test
    public void testSimpleWord(){
        Optional data = this.subject.find("Hammr");

        Assertions.assertThat(data.isPresent()).isTrue();

        Result result = (Result) data.get();
        Assertions.assertThat(result.getWord()).as("Looking for word").isEqualTo("Hammer");
        Assertions.assertThat(result.getAccurateDistance()).isEqualTo(1);
    }


}
