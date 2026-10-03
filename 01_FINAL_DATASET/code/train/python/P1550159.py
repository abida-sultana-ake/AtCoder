H, W = map(int, input().split())
string = list()
for i in range(H):
    string.append(input())

for i in range(W+2):
    print("#", end="")

print("")

for i in range(H):
    print("#", end="")
    print(string[i], end="")
    print("#")

for i in range(W+2):
    print("#", end="")
