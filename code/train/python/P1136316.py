x = int(input())
N2 = x // 11
R = x % 11
if R == 0:
    print(N2 * 2)
elif R <= 6:
    print(N2 * 2 + 1)
else:
    print(N2 * 2 + 2)