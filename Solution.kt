
class Solution {

    private companion object {
        const val ALPHABET_SIZE = 26
    }

    fun majorityFrequencyGroup(input: String): String {
        val frequencyLetters = IntArray(ALPHABET_SIZE)
        for (letter in input) {
            ++frequencyLetters[letter - 'a']
        }

        val frequencyLettersToGroupSize = IntArray(input.length + 1)
        for (current in frequencyLetters) {
            ++frequencyLettersToGroupSize[current]
        }

        var maxGroupSize = 0
        var frequencyMaxGroupSize = 0
        for (frequency in frequencyLettersToGroupSize.size - 1 downTo 1) {
            if (maxGroupSize < frequencyLettersToGroupSize[frequency]) {
                maxGroupSize = frequencyLettersToGroupSize[frequency]
                frequencyMaxGroupSize = frequency
            }
        }

        val uniqueLetters = StringBuilder()
        for (i in 0..<ALPHABET_SIZE) {
            if (frequencyLetters[i] == frequencyMaxGroupSize) {
                uniqueLetters.append('a' + i)
            }
        }

        return uniqueLetters.toString()
    }
}
