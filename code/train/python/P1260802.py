num = input()
num = num.split(" ")

for i in range(3):
    num[i] = int(num[i])

top = num[0] % num[1]

i = 1
n = ( i * num[0] ) % num[1]
while True:

    if n == num[2]:
        print("YES")
        break

    i +=1
    n = ( i * num[0] ) % num[1]

    if n == top:
        print("NO")
        break
