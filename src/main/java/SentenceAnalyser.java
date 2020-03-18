import java.util.Arrays;

public class SentenceAnalyser {

    public SentenceInfo getSentenceInfo(String sentence) {
        SentenceInfo longestWordInfo = getLongestWordAndLength(sentence);
        SentenceInfo shortestWordInfo = getShortestWordAndLength(sentence);
        return new SentenceInfo(longestWordInfo.getLongestWord(), shortestWordInfo.getShortestWord());
    }

    public SentenceInfo getLongestWordAndLength(String sentence) {
        // not handling contractions - they are considered words
        // numbers are not considered words
        // do we need to handle case?
        // in case of multiple words of the same length we take the last occurrence
        sentence.replaceAll("[^a-zA-Z ]", "");
        String[] words = sentence.split(" ");
        Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));
        if (words.length > 0) {
            return new SentenceInfo(words[words.length - 1], words[0]);
        } else {
            return new SentenceInfo("", "");
        }
    }

    public SentenceInfo getShortestWordAndLength(String sentence) {
        return getLongestWordAndLength(sentence);
    }
}
