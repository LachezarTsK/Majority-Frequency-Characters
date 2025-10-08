
#include <array>
#include <string>
#include <vector>
using namespace std;

class Solution {

    static const int ALPHABET_SIZE = 26;

public:
    string majorityFrequencyGroup(const string& input) const {
        array<int, ALPHABET_SIZE> frequencyLetters{};
        for (const auto& letter : input) {
            ++frequencyLetters[letter - 'a'];
        }

        vector<int> frequencyLettersToGroupSize(input.length() + 1);
        for (const auto& current : frequencyLetters) {
            ++frequencyLettersToGroupSize[current];
        }

        int maxGroupSize = 0;
        int frequencyMaxGroupSize = 0;
        for (int frequency = frequencyLettersToGroupSize.size() - 1; frequency >= 1; --frequency) {
            if (maxGroupSize < frequencyLettersToGroupSize[frequency]) {
                maxGroupSize = frequencyLettersToGroupSize[frequency];
                frequencyMaxGroupSize = frequency;
            }
        }

        string uniqueLetters;
        for (int i = 0; i < ALPHABET_SIZE; ++i) {
            if (frequencyLetters[i] == frequencyMaxGroupSize) {
                uniqueLetters.push_back('a' + i);
            }
        }

        return uniqueLetters;
    }
};
