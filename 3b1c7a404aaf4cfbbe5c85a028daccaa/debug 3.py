undoneMatrix = [[1, 2, 3, 4], [5, 6, 7, 8], [9, 0, 1, 2], [3, 4, 5, 6]]
doneMatrix = []

lieNum = len(undoneMatrix)
hangNum = len(undoneMatrix[0])

for i in range(hangNum - 1, -1, -1):
    term = []
    for j in range(0, lieNum):
        x = undoneMatrix[i]
        term.append(x[j])

    doneMatrix.append(term)

print(doneMatrix)