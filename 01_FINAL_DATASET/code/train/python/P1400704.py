S = input()
S = list(S)
A = 0
for i in range(len(S)):
    if S.count(S[i-1]) == 1:
        A += 1
if len(S) == A:
    print("yes")
else:
    print("no")
