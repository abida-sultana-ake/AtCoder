x, y = map(int, input().split())

abc = [[1, 3, 4, 5, 7, 8, 10, 12], [4, 6, 9, 11], [2]]

result = "No"
for i in abc:
    if (x in i) and (y in i):
        result = "Yes"
        break

print(result)