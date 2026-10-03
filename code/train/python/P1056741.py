[k, s] = [int(s) for s in input().split(' ')]
count = 0
for x in range(max(s-2*k, 0), min(k,s)+1):
    count += min(s-x, 2*k-(s-x)) + 1

print(count)
