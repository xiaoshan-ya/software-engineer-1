def password_validate(val):
    myList = list(val)

    import re
    testStr = re.search(r'\W', val)

    test1 = 0

    test2 = 0

    test3 = 0
    num3 =0

    test4 = 0
    num4 = 0
    letter4 = 0

    for i in myList:
        if i <= "9" and i >= "0" and len(myList) < 8:
            test1 += 1

        elif ((i <= 'z' and i >= 'a') or (i <= 'Z' and i >= 'A')) and len(myList) < 8:
            test2 += 1

        elif testStr == None and len(myList) >= 8:
            test3 += 1

            if i <= "9" and i >= "0":
                num3 = 1

        elif len(myList) >= 8 and testStr != None:

            if i <= "9" and i >= "0":
                    num4 = 1
            elif (i <= 'z' and i >= 'a') or (i <= 'Z' and i >= 'A'):
                letter4 = 1

    if test1 == len(myList):
        #print("1")
        return 1
    elif test2 == len(myList):
        #print("2")
        return 2
    elif test3 == len(myList) and num3 == 1:
        #print("3")
        return 3
    elif testStr != None and num4 == 1 and letter4 == 1:
        #print("4")
        return 4
    else:
        #print("0")
        return 0
