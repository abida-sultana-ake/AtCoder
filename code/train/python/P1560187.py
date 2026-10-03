input()
k = [0] * 100000
for a in map(int, input().split()):
    k[a] += 1
print(max(map(sum, zip(k, k[1:], k[2:]))))
