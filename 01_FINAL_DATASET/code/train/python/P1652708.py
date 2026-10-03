x = input()
a = []
check = []
for i in range(int(x)):
    a.append(int(input()) - 1)
    check.append(1)

index = 0
count = 0


while True:
    count += 1
    check[index] = 0
    index = a[index]

    if check[index] == 0:
        print(-1)
        break
    if index == 1:
        print(count)
        break
