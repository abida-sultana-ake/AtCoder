s = str(input())
#condition a
if len(s) % 2 == 0:
    a = 1
else:
    a = 0
    
if s[0] == s[-1]:
    b = 1
else:
    b = 0

ans = bin(a^b)

if ans == bin(0b0):
    print("First")
elif ans == bin(0b1):
    print("Second")
else:
    print("Error!")