N = int(input())
a = list(map(int, input().split(" ")))

su = sum(a)
diff = 1e10
cc = 0

for i in range(len(a)-1):
    cc += a[i]
    diff = min(diff, abs(su-2*cc))
print(diff)