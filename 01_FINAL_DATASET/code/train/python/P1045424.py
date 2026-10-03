n = input().split()
a = [input() for i in range(int(n[0]))]
for i in range(int(n[0]) * 2):
    print (a[int(i / 2)])
