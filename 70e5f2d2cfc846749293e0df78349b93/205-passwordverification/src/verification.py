
def password_verification(user, pwd):
    """
    :param user: The username stored in the computer.
    :param pwd: The password for the user stored in the computer.
    """
    rightUser = user
    rightPwd = pwd

    userName = input('What is the user name? ')
    userPwd = input("What is the password? ")

    if userName == rightUser and userPwd == rightPwd:
        print("Welcome!")

    else:
        print("I don't know you.")

#password_verification('user01', 'abc\$123')
