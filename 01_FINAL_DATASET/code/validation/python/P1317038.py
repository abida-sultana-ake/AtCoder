N = input()
a = map(int, input().split())
b = []

for i, v in enumerate(a):
    b.append((v, i+1))

b.sort(reverse=True)

for i in range(len(b)):
    print(b[i][1])
