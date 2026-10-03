S = input()
a = -1
z = -1
for i in range(len(S)):
    if S[i] == 'Z':
        z = i
    if S[-i - 1] == 'A':
        a = len(S) - i - 1
print(z - a + 1)
