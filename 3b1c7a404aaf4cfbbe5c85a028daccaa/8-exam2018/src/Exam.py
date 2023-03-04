

# check whether a is able to be divided by b with no remainder
# return True or False
# note: if divisor is 0, return False
def is_divisible(a, b):
	if a >= b and a != 0 and b != 0:
		if a % b == 0:
			return True
		else:
			return False
	elif b > a  and a != 0 and b != 0:
		if b % a == 0:
			return True
		else:
			return False
	else:
		return False



# remove the element n in list l
# if n is not in l, return l
def remove_element(l, n):
	list = l
	while True:
		if n in list:
			list.remove(n)
		else:
			break
	return list


# check whether number list l1 and number list l2 are exactly same.(Same size, Same Content)
# return True or False
# note: l1 & l2 may be multi-dimensional
def is_equal_list(l1, l2):
	if len(l1) == len(l2):
		flag = 1
		for i in range(0, len(l1)):
			if l1[i] != l2[i]:
				flag = 0
				break
	else:
		flag = 0

	if flag == 1:
		return True
	else:
		return False

# process the matrix m in required operation d.
# direction 1: Vertical Flip
# direction 2: Horizontal Flip
# direction 3: Transpose
# return processed matrix
# note: m may be two-dimensional
def matrix_process(m, d):
	if d == 2:
		undoneMatrix = m
		doneMatrix = []

		lieNum = len(undoneMatrix)
		hangNum = len(undoneMatrix[0])

		for i in range(0, hangNum):
			term = []
			for j in range(lieNum - 1, -1, -1):
				x = undoneMatrix[i]
				term.append(x[j])

			doneMatrix.append(term)

		return doneMatrix

	elif d == 1:
		undoneMatrix = m
		doneMatrix = []

		lieNum = len(undoneMatrix)
		hangNum = len(undoneMatrix[0])

		for i in range(hangNum - 1, -1, -1):
			term = []
			for j in range(0, lieNum):
				x = undoneMatrix[i]
				term.append(x[j])

			doneMatrix.append(term)

		return doneMatrix

	elif d == 3:
		undoneMatrix = m
		doneMatrix = []

		lieNum = len(undoneMatrix)
		hangNum = len(undoneMatrix[0])

		for i in range(0, hangNum):
			term = []
			for j in range(0, lieNum):
				x = undoneMatrix[j]
				term.append(x[i])

			doneMatrix.append(term)

		return doneMatrix


# read a sentence from given filename, then reverse the order of word and punctuation.
# return reversed sentence
# note1: punctuations still follows the word it follows originally
#     example: "Hello World!" -> "!World Hello"
#                     ^^^^^^      ^^^^^^
# note2: abbreviation with punctuations like "can't" also should be reversed to "t'can"
# possible APIs: str.split(str) str.isalpha() str.join(sequence)
def reverse_sentence_from_file(filename):

	with open(filename, 'r') as myFile:
		words = myFile.read().split()
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

	result = ' '.join(result)
	return result