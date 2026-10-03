n = input()
score = []
s_not10 = []

for i in range(int(n)):
    s = input()
    score.append(int(s))

score.sort()
for j in range(len(score)):
    if score[j]%10 != 0:
        s_not10.append(j)

s_all = int(sum(score))

if s_all%10 != 0:
    best = s_all
elif len(s_not10) == 0:
    best = 0
else:
    best = score[s_not10[-1]]
    if s_all-s_not10[0] > best:
        best = s_all-score[s_not10[0]]

print(best)
