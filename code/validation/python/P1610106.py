a,b = list(int(i) for i in input().split())
if a == 1:
    a = 14
if b == 1:
    b = 14
if a==b:
    print("Draw")
else:
    print("Alice" if a>b else "Bob")