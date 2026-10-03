H, W = map(int,input().split())

print("#" * (W + 2))
for i in range(H):
    print("#" + str(input()) + "#")
print("#" * (W + 2))