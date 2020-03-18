# SDET screening test for T. Rowe Price.

This is a Java project with the tests written using JUnit.

I decided to make the methods return a custom class rather than a map or a tuple because that way the getSentenceInfo 
method can be extended to analyse a sentence more deeply while maintaining backwards compatibility. The SentenceInfo 
class only contains the longest and shortest words and computes the lengths instead of storing them. 

The two methods that were requested in the screening document actually call the same underlying method and return the
same class. This may not be exactly what was asked but helped me simplify the solution. 

There are a number of assumptions that have been made and are documented in the code. These include:
 * not handling contractions - they are considered words
 * numbers are not considered words
 * non-alphabet characters are stripped out
 * Does not handle case
 * in case of multiple words of the same length we take the last occurrence in case of the longest word, first occurrence in the case of the shortest word
 * only works with Latin alphabet
 * an assumption is made that we would like to return an empty string and a zero instead of throwing an exception when receiving an empty sentence
 * we assume the sentence will not be null
 
 In order to build it and run the tests please use the gradle wrapper included in the project.
 
 To build the code use a terminal and type:
```./gradlew clean build```

To run the unit tests you can type
```./gradlew clean test```