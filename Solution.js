
/**
 * @param {string} input
 * @return {string}
 */
var majorityFrequencyGroup = function (input) {
    const ALPHABET_SIZE = 26;
    const ASCII_LOWER_CASE_A = 97;
    const frequencyLetters = new Array(ALPHABET_SIZE).fill(0);
    for (let i = 0; i < input.length; ++i) {
        ++frequencyLetters[input.codePointAt(i) - ASCII_LOWER_CASE_A];
    }

    const frequencyLettersToGroupSize = new Array(input.length + 1).fill(0);
    for (let current of frequencyLetters) {
        ++frequencyLettersToGroupSize[current];
    }

    let maxGroupSize = 0;
    let frequencyMaxGroupSize = 0;
    for (let frequency = frequencyLettersToGroupSize.length - 1; frequency >= 1; --frequency) {
        if (maxGroupSize < frequencyLettersToGroupSize[frequency]) {
            maxGroupSize = frequencyLettersToGroupSize[frequency];
            frequencyMaxGroupSize = frequency;
        }
    }

    const uniqueLetters = new Array();
    for (let i = 0; i < ALPHABET_SIZE; ++i) {
        if (frequencyLetters[i] === frequencyMaxGroupSize) {
            uniqueLetters.push(String.fromCodePoint(ASCII_LOWER_CASE_A + i));
        }
    }

    return uniqueLetters.join('');
};
