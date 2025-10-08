
package main
import "strings"

const ALPHABET_SIZE = 26

func majorityFrequencyGroup(input string) string {
    frequencyLetters := make([]int, ALPHABET_SIZE)
    for _, letter := range input {
        frequencyLetters[letter - 'a']++
    }

    frequencyLettersToGroupSize := make([]int, len(input) + 1)
    for _, current := range frequencyLetters {
        frequencyLettersToGroupSize[current]++
    }

    maxGroupSize := 0
    frequencyMaxGroupSize := 0
    for frequency := len(frequencyLettersToGroupSize) - 1; frequency >= 1; frequency-- {
        if maxGroupSize < frequencyLettersToGroupSize[frequency] {
            maxGroupSize = frequencyLettersToGroupSize[frequency]
            frequencyMaxGroupSize = frequency
        }
    }

    uniqueLetters := strings.Builder{}
    for i := range ALPHABET_SIZE {
        if frequencyLetters[i] == frequencyMaxGroupSize {
            uniqueLetters.WriteByte(byte('a' + i))
        }
    }

    return uniqueLetters.String()
}
