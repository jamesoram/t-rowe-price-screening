import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class SentenceAnalyserTest {

    @Parameterized.Parameters
    public static Collection<Object[]> parameters() {
        return Arrays.asList(
                new Object[][] {
                        {"The cow jumped over the moon.", "jumped", 6},
                        {"Lorem ipsum", "ipsum", 5}
                }
        );
    }

    private String sentence;
    private String longestWord;
    private int longestWordLength;
    private SentenceAnalyser sentenceAnalyser = new SentenceAnalyser();

    public SentenceAnalyserTest(String sentence, String longestWord, int longestWordLength) {
        this.sentence = sentence;
        this.longestWord = longestWord;
        this.longestWordLength = longestWordLength;
    }

    // an assumption is made that we would like to return an empty string and a zero instead of throwing an exception
    @Test
    public void testEmptySentence() {
        SentenceInfo sentenceInfo = sentenceAnalyser.getLongestWordAndLength("");
        assertEquals("", sentenceInfo.getLongestWord());
        assertEquals(0, sentenceInfo.getLongestWordLength());
    }

    @Test
    public void testLongestWordAndLength() {
        SentenceInfo sentenceInfo = sentenceAnalyser.getLongestWordAndLength(sentence);
        assertEquals(longestWord, sentenceInfo.getLongestWord());
        assertEquals(longestWordLength, sentenceInfo.getLongestWordLength());
    }
}
