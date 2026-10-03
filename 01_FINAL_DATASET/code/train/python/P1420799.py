m, n, o = map(int, input().split())
p = m + n
q = m - n
if p == o and q == o:
    print("?")
elif p == o:
    print("+")
elif q == o:
    print("-")
else:
    print("!")
