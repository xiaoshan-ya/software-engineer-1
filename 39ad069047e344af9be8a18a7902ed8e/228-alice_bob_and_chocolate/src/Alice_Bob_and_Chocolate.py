"""write your code in method solve"""
def solve():

    number = int(input())
    times = input().split()

    amountNum = []
    for i in times:
        amountNum.append(int(i))

    if len(times) > 2:
        aliceNum = 0
        bobNum = len(times) - 1
        aliceTime = amountNum[aliceNum]
        bobTime = amountNum[bobNum]

        aliceCnt = 0
        bobCnt = 0

        while True:
            if aliceTime < bobTime and aliceNum < bobNum - 1:

                aliceNum += 1
                aliceCnt += 1

                bobTime -= aliceTime

                aliceTime = amountNum[aliceNum]

            elif aliceTime > bobTime and aliceNum < bobNum - 1:

                bobNum -= 1
                bobCnt += 1

                aliceTime -= bobTime

                bobTime = amountNum[bobNum]

            elif aliceTime == bobTime and aliceNum == bobNum:#相遇时
                aliceCnt += 1
                print(str(aliceCnt) + ' ' + str(bobCnt))
                break

            elif aliceTime == bobTime and aliceNum < bobNum - 1:
                aliceNum += 1
                bobNum -= 1

                aliceCnt += 1
                bobCnt += 1

                aliceTime = amountNum[aliceNum]
                bobTime = amountNum[bobNum]

            elif aliceTime == bobTime and aliceNum == bobNum - 1:
                aliceCnt += 1
                print(str(aliceCnt) + ' ' + str(bobCnt))
                break

            if aliceCnt + bobCnt == len(amountNum) or aliceNum == bobNum - 1:
                print(str(aliceCnt + 1) + ' ' + str(bobCnt + 1))
                break

    elif len(times) == 1:
        print("1 0")
    else:
        print("1 1")

