package de.pgeprojects.didyoumean;

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
        Word result = this.subject.word("Hammr");

        Assertions.assertThat(null != result).isTrue();
        Assertions.assertThat(result.toString()).as("Looking for word").isEqualTo("Hammer");
        Assertions.assertThat(result.getDistance()).isEqualTo(1);
    }

    @Test
    public void testSimpleSentence(){
        Sentence result = this.subject.sentence("Was ein toller Hammr");
        Assertions.assertThat(null != result).isTrue();
        String sentence = result.getContent();
        Assertions.assertThat(sentence).contains("Hammer");
    }

}
