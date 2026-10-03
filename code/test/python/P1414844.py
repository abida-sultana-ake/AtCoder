M = list(input())
l = len(M)
N = []
for i in range(l):
    if M[i] != "a" and M[i] != "i" and M[i] != "u" and M[i] != "e" and M[i] != "o":
        N.append(M[i])
ans = "".join(map(str, N))
print(ans)