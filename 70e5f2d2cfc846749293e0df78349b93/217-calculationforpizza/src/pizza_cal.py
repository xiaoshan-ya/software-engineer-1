import math


def pizza_calculation():
    #people = int(input('How many people?'))
    #pizza = int(input('How many pizzas do you have?'))
    #piece = int(input('How many pieces does each pizza have?'))
    #total = pizza * piece
    #left = total % people
    #each_pizza = math.floor((total - left) / people)
    #print('Each people gets %d pieces of pizza' % each_pizza)
    #print('%d leftover pieces' % left)

    peopleNum = int(input("How many people? "))
    pizzzaNum = int(input('How many pizzas do you have? '))
    pieces = int(input("How many pieces does each pizza have? "))

    getPizza = int(pizzzaNum * pieces / peopleNum)

    restPieces = pizzzaNum * pieces - getPizza * peopleNum

    print("Each people gets " + str(getPizza) + " pieces of pizza")

    print(str(restPieces) + " leftover pieces")


# pizza_calculation()