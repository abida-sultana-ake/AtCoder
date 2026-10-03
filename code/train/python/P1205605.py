N = int(input())
S = input()
res = [0 for i in range(0, 4)]
for i in range(0, N):
    res[int(S[i])-1] += 1

res.sort()

print(str(res[3]) + " " + str(res[0]))