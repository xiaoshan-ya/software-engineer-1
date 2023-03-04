
undoneMatrix = [[1, 2, 3, 4], [5, 6, 7, 8], [9, 0, 1, 2], [3, 4, 5, 6]]
doneMatrix = []

lieNum = len(undoneMatrix)
hangNum = len(undoneMatrix[0])

print(lieNum)
print(hangNum)

for i in range(0, hangNum):
    term = []
    for j in range(0, lieNum):
        x = undoneMatrix[j]
        term.append(x[i])

    doneMatrix.append(term)

print(doneMatrix)