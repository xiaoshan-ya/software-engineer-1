"""write your code in method"""


def is_dangerous():
	string = int(input())
	people = []
	while string != 0:
		people.append(string % 10)
		string /= 10
		string  = int(string)

	cnt0 = 0
	cnt1 = 0

	for i in people:
		if i == 1:
			cnt1 += 1
			cnt0 = 0

		if i == 0:
			cnt0 += 1
			cnt1 = 0

		if cnt1 == 7 or cnt0 == 7:
			break

	if cnt1 == 7 or cnt0 == 7:
		print('YES')
	else:
		print('NO')
