A = input().split()

B = int("".join(A))

while B > 4:
        B %= 4

if B == 0:
        print("YES")
else:
        print("NO")