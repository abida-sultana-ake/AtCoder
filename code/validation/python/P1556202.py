E,B,L = input().split(),input(),input().split()
count = 0
for c in E:
    if c in L: count += 1
if count == 6:
    print(1)
elif count == 5:
    print(2 if B in L else 3)
elif count == 4:
    print(4)
elif count == 3:
    print(5)
else:
    print(0)
