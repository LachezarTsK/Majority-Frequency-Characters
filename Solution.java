
public class Solution {

    private static final int ALPHABET_SIZE = 26;

    public String majorityFrequencyGroup(String input) {
        int[] frequencyLetters = new int[ALPHABET_SIZE];
        for (char letter : input.toCharArray()) {
            ++frequencyLetters[letter - 'a'];
        }

        int[] frequencyLettersToGroupSize = new int[input.length() + 1];
        for (int current : frequencyLetters) {
            ++frequencyLettersToGroupSize[current];
        }

        int maxGroupSize = 0;
        int frequencyMaxGroupSize = 0;
        for (int frequency = frequencyLettersToGroupSize.length - 1; frequency >= 1; --frequency) {
            if (maxGroupSize < frequencyLettersToGroupSize[frequency]) {
                maxGroupSize = frequencyLettersToGroupSize[frequency];
                frequencyMaxGroupSize = frequency;
            }
        }

        StringBuilder uniqueLetters = new StringBuilder();
        for (int i = 0; i < ALPHABET_SIZE; ++i) {
            if (frequencyLetters[i] == frequencyMaxGroupSize) {
                uniqueLetters.append((char) ('a' + i));
            }
        }

        return uniqueLetters.toString();
    }
}
