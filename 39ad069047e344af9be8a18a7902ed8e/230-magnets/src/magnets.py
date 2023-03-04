"""write your code in method solve"""
def solve():
    allNum = int(input())
    magnets = []
    for i in range(0, allNum):
        x = input()
        magnets.append(x)

    cnts = []
    cnt = 1
    for i in range(0, len(magnets) - 1):
        magnetFront = list(magnets[i])
        magnetBehind = list(magnets[i + 1])

        if magnetFront[1] != magnetBehind[0]:
            cnt += 1
        else:
            cnts.append(cnt)
            cnt = 0

    print(len(cnts) + 1)

solve()