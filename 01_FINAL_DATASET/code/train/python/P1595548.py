x, a, b = [int(i) for i in input().split(' ')]
print('A' if abs(x-a) < abs(x-b) else 'B')