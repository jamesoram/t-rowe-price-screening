// this could be a map or a tuple but I decided to create a new class for extensibility purposes
public class SentenceInfo {

    private String longestWord;
    private String shortestWord;

    public SentenceInfo(String longestWord, String shortestWord) {
        this.longestWord = longestWord;
        this.shortestWord = shortestWord;
    }

    public String getLongestWord() {
        return longestWord;
    }

    public String getShortestWord() {
        return shortestWord;
    }

    private int getWordLength(String word) {
        if (null != shortestWord) {
            return shortestWord.length();
        } else {
            return 0;
        }
    }

    public int getShortestWordLength() {
        return getWordLength(shortestWord);
    }

    public int getLongestWordLength() {
        return getWordLength(longestWord);
    }
}
