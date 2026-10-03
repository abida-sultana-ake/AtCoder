n,k = map(int,input().split())
r = sorted(list(map(int,input().split())))
rate = 0.0

for i in r[-k:]:
    rate = (rate+i)/2
print(rate)
