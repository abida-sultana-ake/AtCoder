s = input()
t = input()

def check(a, b):
    if a == b:
        return True
    elif a == '@':
        return b in list('atcoder')
    elif b == '@':
        return a in list('atcoder')

ans = True
for i in range(len(s)):
    if not check(s[i], t[i]):
        ans = False

if ans:
    print('You can win')
else:
    print('You will lose')
    
