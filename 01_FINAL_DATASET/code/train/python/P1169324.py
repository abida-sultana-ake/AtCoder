X = int(input())
count = 0
sumnum = 0
X = abs(X)
while True:
    count += 1
    sumnum += count
    if sumnum >= X:
        break
print(count)
