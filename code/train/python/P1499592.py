from math import sqrt

x_a, y_a, x_b, y_b, T, V = map(int , input().split())
n = int(input())
girls = [list(map(int , input().split())) for i in range(n)]

def distance(x_1, y_1, x_2, y_2):
    return sqrt((x_1-x_2)**2 + (y_1-y_2)**2)

for girl in girls:
    distance_1 = distance(x_a, y_a, girl[0], girl[1])
    distance_2 = distance(girl[0], girl[1], x_b, y_b)

    if (distance_1 + distance_2) <= T * V:
        print("YES")
        break

else:
    print("NO")
    