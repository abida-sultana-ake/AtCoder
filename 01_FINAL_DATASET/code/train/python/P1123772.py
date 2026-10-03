A, B, C = list(map(int, input().split()))
p = False
m = False
if A+B == C:
    p = True
if A-B == C:
    m = True

if p and m:
    print("?")
elif p:
    print("+")
elif m:
    print("-")
else:
    print("!")
