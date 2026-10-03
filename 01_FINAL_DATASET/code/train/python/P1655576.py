S = input()
s = []
ans = []
num = 0
count = 0
for i in range(len(S)):
    s.append(ord(S[i]))
while num < len(s) - 2:
    if s[num] is not s[num + 2]:
        s.pop(num + 1)
        num = 0
        count += 1
    else:
        num += 1


for i in range(len(s)):
    ans.append(chr(s[i]))

if count % 2 is 1:
    print('First')
else:
    print('Second')
