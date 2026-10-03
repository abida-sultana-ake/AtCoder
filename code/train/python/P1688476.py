n = int(input())
ctr = 0
while n > 0:
    if ctr%2 == 0:
        n //= 2
    else:
        n = (n-1) // 2
    ctr += 1
if ctr % 2 == 0:
    print("Takahashi")
else:
    print("Aoki")
