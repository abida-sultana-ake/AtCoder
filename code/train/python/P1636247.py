S = input()
S = S[::-1]
W = ['dream', 'dreamer', 'erase', 'eraser']
for n in range(4):
    W[n] = W[n][::-1]
check = 0
i = 0
while i < len(S):
    check = 0
    for w in W:
        if w in S[i:i+len(w)]:
            i += len(w)
            check = 1
    if check is 0:
        break
if check is 1:
    print('YES')
else:
    print('NO')
