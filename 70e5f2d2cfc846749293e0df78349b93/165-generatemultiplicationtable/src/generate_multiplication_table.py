
def generate():
    n = int(input("\n"))
    
    for i in range(0, n + 1):
        for j in range(0, n + 1):
            print(str(i) + ' X ' + str(j) + ' = ' + str(i*j))
