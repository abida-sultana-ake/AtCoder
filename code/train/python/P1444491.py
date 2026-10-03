n = int(input())
a = list(map(int, input().split()))
petals = 0

for i in a:
    if i in {1, 3, 7, 9}:
        petals += 0
    elif i in {2, 4, 8}:
        petals += 1
    elif i == 5:
        petals += 2
    elif i == 6:
        petals += 3

print(petals)
