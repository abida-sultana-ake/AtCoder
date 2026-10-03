tousen = list(map(int, input().split()))

b = int(input())

num = list(map(int, input().split()))
count = 0
bou = 0

for i in range(len(num)):
    ans = num[i] in tousen
    if ans == True:
        count += 1
    elif num[i] == b:
        bou += 1

if count == 6:
    print(1)
elif count == 5:
    if bou == 1:
        print(2)
    else:
        print(3)
elif count == 4:
    print(4)
elif count == 3:
    print(5)
else:
    print(0)
