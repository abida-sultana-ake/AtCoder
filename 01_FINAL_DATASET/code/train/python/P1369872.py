N, A, B = [int(i) for i in input().split()]
move = []

for i in range(N):
    t, s = input().split()
    move.append([t, int(s)])

place = 0

for i in range(N):
    distance = 0
    if move[i][1] < A:
        distance = A
    elif move[i][1] > B:
        distance = B
    else:
        distance = move[i][1]

    if move[i][0] == 'West':
        place -= distance
    else:
        place += distance

if place > 0:
    print('East',place)
elif place < 0:
    print('West',abs(place))
else:
    print(0)
