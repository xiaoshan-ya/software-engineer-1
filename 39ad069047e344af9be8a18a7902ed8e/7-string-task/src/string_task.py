"""write your code in method"""


def get_string():
    string = input().lower().replace('\n', '')
    words = list(string)

    result = ''

    for word in words:

        if word == 'a' or word == 'e' or word == 'i' or word == 'o' or word == 'u':
            continue
        else:
            result = result + '.' + word

    print(result)
