n, k = list(map(int, input().split()))
d = list(map(int, input().split()))
c = n
while True:
    if not any(str(x) in str(c) for x in d):
        break
    c += 1
print(c)
