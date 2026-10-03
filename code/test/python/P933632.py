s = list(str(input()))
ans = []
score = 0
for i in range(len(s)):
    if i % 2 == 0:
        ans.append('g')
    else:
        ans.append('p')
for i in range(len(s)):
    if s[i] == 'p' and ans[i] == 'g':
        score -= 1
    elif s[i] == 'g' and ans[i] == 'p':
        score +=1
print(score)

