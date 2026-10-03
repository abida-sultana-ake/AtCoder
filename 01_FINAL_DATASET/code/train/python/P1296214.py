H, W = list(map(int, input().split()))

print("#" * (W + 2))
for i in range(H):
    print("#" + input() + "#")

print("#" * (W + 2))
