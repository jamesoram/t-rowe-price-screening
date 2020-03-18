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
                        {"The cow jumped over the moon.", "jumped", 6, "The", 3},
                        {"Lorem ipsum", "ipsum", 5, "Lorem", 5},
                        {"A career at T. Rowe Price says you want to contribute", "contribute", 10, "A", 1},
                        {"", "", 0, "", 0},
                        {"31337, ", "", 0, "", 0},
                        {"It's a great sentence", "sentence", 8, "a", 1},
                        {"漢語 汉语 汉字/漢字", "", 0, "", 0}
                }
        );
    }

    private String sentence;
    private String longestWord;
    private int longestWordLength;
    private String shortestWord;
    private int shortestWordLength;
    private SentenceAnalyser sentenceAnalyser = new SentenceAnalyser();

    public SentenceAnalyserTest(String sentence, String longestWord, int longestWordLength,
                                String shortestWord, int shortestWordLength) {
        this.sentence = sentence;
        this.longestWord = longestWord;
        this.longestWordLength = longestWordLength;
        this.shortestWord = shortestWord;
        this.shortestWordLength = shortestWordLength;
    }

    @Test
    public void testLongestWordAndLength() {
        SentenceInfo sentenceInfo = sentenceAnalyser.getLongestWordAndLength(sentence);
        assertEquals(longestWord, sentenceInfo.getLongestWord());
        assertEquals(longestWordLength, sentenceInfo.getLongestWordLength());
    }

    @Test
    public void testShortestWordAndLength() {
        SentenceInfo sentenceInfo = sentenceAnalyser.getShortestWordAndLength(sentence);
        assertEquals(shortestWord, sentenceInfo.getShortestWord());
        assertEquals(shortestWordLength, sentenceInfo.getShortestWordLength());
    }
}
