"""write your code in method"""


def get_year():
    year = int(input())

    i = year

    flag = 1

    while True:
        i += 1
        years = list(str(i))

        for word in years:

            cnt = 0
            for j in years:
                if word == j:
                    cnt += 1

            if cnt > 1:
                flag = 0
                break
            else:
                flag = 1

        if flag == 1:
            break

    print(i)
