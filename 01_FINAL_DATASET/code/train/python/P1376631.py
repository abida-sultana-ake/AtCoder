n = int(input())
light = 1
count = 0
a = []
for i in range(n):
    a.append(int(input()))
while count < n:
    light = a[light-1]
    count += 1
    if light == 2:
        print(count)
        quit()
print(-1)
