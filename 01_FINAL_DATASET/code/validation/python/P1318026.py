n = int(input())
s = str(input())
acc = ''
ans = -1
for i in range(n+2):
    if acc == s:
        ans = i-1
        break
    elif len(acc) > len(s):
        break
    if i == 0:
        acc += 'b'
    elif i % 3 == 1:
        acc = 'a' + acc + 'c'
    elif i % 3 == 2:
        acc = 'c' + acc + 'a'
    else:
        acc = 'b' + acc + 'b'
print(ans)
