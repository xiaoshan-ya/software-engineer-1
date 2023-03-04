"""write your code in method solve"""
def solve():
    strs = input().split()
    candles = int(strs[0])
    renew = int(strs[1])

    time = 0
    old = 0
    while True:
        time += candles
        old += candles

        candles = 0

        candles = int(old / renew)
        old = old - candles * renew

        if old < renew and candles == 0:
            break

    print(time)