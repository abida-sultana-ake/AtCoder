def is_factor(x):
    if x == 1:
        return 0
    for i in range(2, x):
        if not x%i:
            return 0
    return 1

n = int(input())
if is_factor(sum(range(n+1))):
    print("WANWAN")
else:
    print("BOWWOW")
