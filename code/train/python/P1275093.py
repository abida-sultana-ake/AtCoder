n, a, b = [int(x) for x in input().split(' ')]
dist = 0
for i in range(n):
    list = input().split(' ')
    list[1] = int(list[1])
    if list[1] < a:
        list[1] = a
    elif list[1] > b:
        list[1] = b
    if list[0] == 'West':
        list[1] = -list[1]
    dist += list[1]
if dist > 0:
    print('East',dist)
elif dist < 0:
    print('West', - dist)
else:
    print(0)
        