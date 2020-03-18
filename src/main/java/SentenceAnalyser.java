import java.util.Arrays;

public class SentenceAnalyser {

    public SentenceInfo getSentenceInfo(String sentence) {
        // not handling contractions - they are considered words
        // numbers are not considered words
        // non-alphabet characters are stripped out
        // do we need to handle case?
        // in case of multiple words of the same length we take the last occurrence
        // only works with Latin alphabet
        // an assumption is made that we would like to return an empty string and a zero instead of throwing an exception when receiving an empty sentence
        String[] words = sentence.replaceAll("[^a-zA-Z ]", "").split(" ");
        Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));
        if (words.length > 0) {
            return new SentenceInfo(words[words.length - 1], words[0]);
        } else {
            return new SentenceInfo("", "");
        }
    }

    public SentenceInfo getLongestWordAndLength(String sentence) {
        return getSentenceInfo(sentence);
    }

    public SentenceInfo getShortestWordAndLength(String sentence) {
        return getSentenceInfo(sentence);
    }
}
