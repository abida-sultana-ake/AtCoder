from bisect import bisect
n = int(input())
cards = [0]*n
for i in range(n):
    cards[i] = int(input()) - 1
asce = [10**5]*(n+5)
asce[0] = -1
for no in cards:
    idx = bisect(asce,no)
    asce[idx] = no

i = 0
while asce[i] < 10**5:
    i+=1
print(n-i+1)
