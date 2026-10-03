d = {1: 1, 2: 2, 3: 1, 4: 3, 5: 1, 6: 3, 7: 1, 8: 1, 9: 3, 10: 1, 11: 3, 12: 1}
x, y = map(int, input().split())

if d[x] == d[y]:
    print('Yes')
else:
    print('No')