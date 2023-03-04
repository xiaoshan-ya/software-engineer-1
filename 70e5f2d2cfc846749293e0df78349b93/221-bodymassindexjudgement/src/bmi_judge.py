import decimal
from decimal import Decimal


def bmi():
    height = int(input("What is your height? "))
    weight = int(input("What is your weight? "))

    bmi = (weight / (height * height)) * 703

    #if bmi - round(bmi,1) < 0.05:
        #bmi += 0.1

    print('Your BMI is ' + "%.1f" % ((bmi - 0.05) + 0.1) + '.')

    bmi = round((bmi - 0.05) + 0.1, 1)

    if bmi >= 18.5 and bmi <= 25:
        print("You are within the ideal weight range.")

    elif bmi > 25:
        print("You are overweight.You should see your doctor.")

    elif bmi < 18.5:
        print("You are underweight.You should see your doctor.")


def decimal_retain(number, ndigits=0):
    """
    Round a number to a given precision in decimal digits (default 0 digits).
    The strategy is : Low values rounded up.
    :param number: The number needed to be rounded.
    :param ndigits: The number of digits.
    :return: The number after being rounded.
    """
    context = decimal.getcontext()
    context.rounding = decimal.ROUND_UP
    return round(Decimal(str(number)), ndigits)
