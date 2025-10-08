
using System;

public class Solution
{
    private static readonly int ALPHABET_SIZE = 26;

    public string MajorityFrequencyGroup(string input)
    {
        int[] frequencyLetters = new int[ALPHABET_SIZE];
        foreach (char letter in input)
        {
            ++frequencyLetters[letter - 'a'];
        }

        int[] frequencyLettersToGroupSize = new int[input.Length + 1];
        foreach (int current in frequencyLetters)
        {
            ++frequencyLettersToGroupSize[current];
        }

        int maxGroupSize = 0;
        int frequencyMaxGroupSize = 0;
        for (int frequency = frequencyLettersToGroupSize.Length - 1; frequency >= 1; --frequency)
        {
            if (maxGroupSize < frequencyLettersToGroupSize[frequency])
            {
                maxGroupSize = frequencyLettersToGroupSize[frequency];
                frequencyMaxGroupSize = frequency;
            }
        }

        StringBuilder uniqueLetters = new StringBuilder();
        for (int i = 0; i < ALPHABET_SIZE; ++i)
        {
            if (frequencyLetters[i] == frequencyMaxGroupSize)
            {
                uniqueLetters.Append((char)('a' + i));
            }
        }

        return uniqueLetters.ToString();
    }
}
