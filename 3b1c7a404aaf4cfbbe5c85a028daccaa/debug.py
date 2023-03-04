words = "Hello World!"
words = words.split()
result = []
reverseWords = []

for i in range(len(words) - 1, -1, -1):
    if words[i].isalpha() == True:
        result.append(words[i])

    else:
        wordList = list(words[i])
        alphaNum = -1

        for word in wordList:
            alphaNum += 1
            if word.isalpha() == False:
                break

        #string = wordList[alphaNum + 1:] + wordList[alphaNum] + wordList[0, alphaNum - 1]
        #reverseWords.append(string)
        if alphaNum == len(wordList) - 1:
            reverseWords.append(wordList[alphaNum])
            reverseWords.append(''.join(wordList[0: alphaNum]))
        elif alphaNum == 0:
            reverseWords.append(''.join(wordList[alphaNum + 1:]))
            reverseWords.append(wordList[alphaNum])
        else:
            reverseWords.append(''.join(wordList[alphaNum + 1:]))
            reverseWords.append(wordList[alphaNum])
            reverseWords.append(''.join(wordList[0: alphaNum]))


        string = ''.join(reverseWords)
        result.append(string)
print(' '.join(result))


