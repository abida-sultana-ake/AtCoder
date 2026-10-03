N = int(input())

Takahashi = 0
Aoki = 0

for i in range(N):
    li = list(input())
    t  =li.count("R")
    a = li.count("B")
    Takahashi += t
    Aoki += a

if Takahashi == Aoki:
    print("DRAW")
elif Takahashi > Aoki:
    print("TAKAHASHI")
else:
    print("AOKI")
