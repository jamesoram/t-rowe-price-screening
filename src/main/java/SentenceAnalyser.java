import java.util.Arrays;

public class SentenceAnalyser {
    /**
     * getSentenceInfo will return a SentenceInfo object with information about the sentence
     *
     * not handling contractions - they are considered words
     * numbers are not considered words
     * non-alphabet characters are stripped out
     * Does not handle case
     * in case of multiple words of the same length we take the last occurrence in case of the longest word, first occurrence in the case of the shortest word
     * only works with Latin alphabet
     * an assumption is made that we would like to return an empty string and a zero instead of throwing an exception when receiving an empty sentence
     * we assume sentence will not be null
     * @param sentence
     * @return SentenceInfo object
     */
    public SentenceInfo getSentenceInfo(String sentence) {
        String[] words = sentence.replaceAll("[^a-zA-Z ]", "").split(" ");
        Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));
        if (words.length > 0) {
            return new SentenceInfo(words[words.length - 1], words[0]);
        } else {
            return new SentenceInfo("", "");
        }
    }

    /**
     * will return the longest word in the sentence and that word's length.
     * If there are multiple longest words it will choose the last one.
     * @param sentence
     * @return SentenceInfo with the longest word and length
     */
    public SentenceInfo getLongestWordAndLength(String sentence) {
        return getSentenceInfo(sentence);
    }

    /**
     * will return ther shortest word in the sentence and that word's length.
     * If there are multiple shortest words it will choose the first one.
     * @param sentence
     * @return SentenceInfo with the shortest word and length
     */
    public SentenceInfo getShortestWordAndLength(String sentence) {
        return getSentenceInfo(sentence);
    }
}
