

def room_area_calculation():
    length = int(input("What is the length of the room in feet? "))
    width = int(input("What is the width of the room in feet? "))

    import math

    feetSquare = math.floor(length*width)

    print(str(feetSquare) + " square feet")
    print('%.3f' % (length * width * 0.09290304) + " square meters")
