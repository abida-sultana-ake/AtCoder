N = int(input())
a = list(map(int, input().split()))

count2 = 0
count4 = 0

for ai in a:
    if ai % 4 == 0:
        count4 += 1
    elif ai % 2 == 0:
        count2 += 1

if count4*2 + count2 >= N or (count4*2+1) >= N:
    print("Yes")
else:
    print("No")