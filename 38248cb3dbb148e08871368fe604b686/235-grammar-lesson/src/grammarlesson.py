def isPetyaLanguage():
    wordstring = input()
    wordList = wordstring.split(' ')

    flag = 1#为了接下来是否要执行女性的情况进行判断

    #if wordList[1].endswith('liala') or wordList[1].endswith('etr') or wordList[1].endswith('initis'):#是男性地情况
    if len(wordList[0]) >= 6:
        if wordList[0].endswith('initis'):
            isprime = 1#为判断词尾是否全部符合情况
    if len(wordList[0]) >= 5:
        if wordList[0].endswith('liala') or wordList[0].endswith('initis'):
            isprime = 1  # 为判断词尾是否全部符合情况
    if len(wordList[0]) >= 3:
        if wordList[0].endswith('liala') or wordList[0].endswith('etr') or wordList[0].endswith('initis'):
            isprime = 1  # 为判断词尾是否全部符合情况


        for word in wordList:

            i = 0#i记录下标

            #if word.endswith('liala') or word.endswith('etra') or word.endswith('inites'):#如果出现女性情况则直接跳出
            if len(word) >=4:
                if word.endswith('liala') or word.endswith('etra') or word.endswith('inites'):#如果出现女性情况则直接跳出
                    print("NO")
                    flag = 0
                    break

            if len(word) >= 5:
                if word.endswith('liala') or word.endswith('inites'):#如果出现女性情况则直接跳出
                    print("NO")
                    flag = 0
                    break
            if len(word) >= 6:
                if word.endswith('inites'):#如果出现女性情况则直接跳出
                    print("NO")
                    flag = 0
                    break

            else:
                adj = [0]
                n = [0]
                v = [0]

                #if word.endswith('lios') or word.endswith('etr') or word.endswith('initis'):#当word符合词尾时
                if len(word) >= 3:
                    if word.endswith('lios') or word.endswith('etr') or word.endswith('initis'):#当word符合词尾时
                        if word.endswith('lios'):
                            adj.append(i)
                        elif word.endswith('etr'):
                            n.append(i)
                        elif word.endswith('initis'):
                            v.append(i)

                        i += 1
                        continue

                if len(word) >= 4:
                    if word.endswith('lios') or word.endswith('initis'):#当word符合词尾时
                        if word.endswith('lios'):
                            adj.append(i)
                        elif word.endswith('initis'):
                            v.append(i)

                        i += 1
                        continue

                if len(word) > 6:
                    if word.endswith('initis'):#当word符合词尾时
                        if word.endswith('lios'):
                            adj.append(i)
                        elif word.endswith('etr'):
                            n.append(i)
                        elif word.endswith('initis'):
                            v.append(i)

                        i += 1
                        continue

                else:
                    isprime = 0

    if isprime == 1 and (max(adj) < min(n) or len(adj) == 1 or len(n) == 1) and (max(n) < min(v) or len(n) == 1 or len(v) == 1) and (max(adj) < min(v) or len(adj) == 1 or len(v) == 1):
        print("YES")
    elif isprime == 0:
        print('NO')
    else:
        print('NO')
