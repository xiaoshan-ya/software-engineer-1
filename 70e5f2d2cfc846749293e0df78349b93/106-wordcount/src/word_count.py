#! /usr/bin/env python
# -*- coding: utf-8 -*-


def wordcount(filepath):
    import re
    with open(filepath) as myyFile:

        wordDict = {}

        for line in myyFile:
            wordList = list(line.split())

            for word in wordList:

                if word in wordDict:
                    wordDict[word] += 1
                else:
                    wordDict[word] = 1

    keys = wordDict.keys()
    maxLenKey = ''#找到最长的key
    for key in keys:
        if len(key) > len(maxLenKey):
            maxLenKey = key

    wordDict = sorted(wordDict.items())
    orderedWordDict = sorted(wordDict, key=lambda x: x[1], reverse=True)

    for item in orderedWordDict:
        print(item[0] + ":", end=" ")
        for i in range(0,len(maxLenKey) - len(item[0])):
            print(" ", end='')

        for j in range(0, item[1]):
            print("*", end='')
        print("\n",end='')
