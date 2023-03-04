"""write your code in following methods"""
file_path = './tasks.txt'


def to_do():
    commands = input()

    # 增加待办事项
    if commands[6] == 'a':
        with open(file_path, 'w') as myFile:
            commands = commands[9:-2].split('" "')

            for command in commands:
                string = 'todo:' + command
                myFile.write(string)

    # 删除待办事项
    elif commands[6] == 'd':
        deletes = commands[9:-2].split('" "')
        recommands = []

        with open(file_path, 'r') as myFile:
            for line in myFile.readline():
                line = line.strip('\n')
                recommands.append(line)

        with open(file_path, 'w') as myFile:
            for recommand in recommands:

                if recommand in deletes:
                    continue
                else:
                    string = 'todo:' + recommand
                    myFile.write(string)

        #修改待办事项为已完成
    elif commands[6] == 'c':
            completes = commands[9:-2].split('" "')
            recommands = []

            with open(file_path, 'r') as myFile:
                for line in myFile.readline():
                    line = line.strip('\n')
                    recommands.append(line)

            with open(file_path, 'w') as myFile:
                for recommand in recommands:

                    if recommand in completes:
                        string = 'completed:' + recommand
                        myFile.write(string)
                    else:
                        string = 'todo:' + recommand
                        myFile.write(string)

        #查询已完成事项、待办事项
    elif commands[6] == 'f':
            findCommands = commands[8:].split()
            recommands = []

            with open(file_path, 'r') as myFile:
                for line in myFile.readline():
                    line = line.strip('\n')
                    recommands.append(line)

            for recommand in recommands:

                if recommand[:8] == 'completed':
                    print(recommand)
                elif recommand[0:3] == 'todo':
                    print(recommand)

            #查询所有事项
    elif commands[-3:] == 'all':
                #recommands = []

                with open(file_path, 'r') as myFile:
                    for line in myFile.readline():
                        line = line.strip('\n')
                        print(line)
                        #recommands.append(line)
