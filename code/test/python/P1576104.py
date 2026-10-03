name = {}
N = int(input())
for i in range(N):
    S = input()
    if S in name:
        name[S] += 1
    else:
        name[S] = 1
print(max(name, key=lambda x: name[x]))