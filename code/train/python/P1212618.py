s = input()
t = input()
q = int(input())

ss, tt = [0], [0]
for i in range(len(s)):
    ss.append(ss[i] + (1 if s[i] == 'A' else 2))
for i in range(len(t)):
    tt.append(tt[i] + (1 if t[i] == 'A' else 2))

for i in range(q):
    a, b, c, d = map(int, input().split())
    s_score = (ss[b] - ss[a-1]) % 3
    t_score = (tt[d] - tt[c-1]) % 3
    print('YES' if s_score == t_score else 'NO')