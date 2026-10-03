N = int(input())
C = input()

d={str(c):0 for c in range(1,5)}
for c in C[:N]:
    d[c] += 1

print(max(d.values()),min(d.values()))
