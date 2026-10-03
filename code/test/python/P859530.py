w = list(input())

def check(w):
    for x in w:
        n = w.count(x)
        if n%2 == 1:
            return False
    return True

if check(w):
    print("Yes")
else:
    print("No")
