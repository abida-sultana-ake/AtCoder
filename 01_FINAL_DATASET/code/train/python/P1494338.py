K = int(input())

b = K % 50
a = K // 50
	
list = [0] * 50
j = 0

while (j <= 49 - b) :
	list[j] = 49 + a - b
	j += 1

while (j <= 49):
	list[j] = 2 * 50 + a - b
	j += 1

list = map(str, list)
print('50')
print(' '.join(list))