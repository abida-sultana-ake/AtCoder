num = input().split()
num = [int(x) for x in num]

for i in num:
    if num.count(i) == 1:
        print(i)