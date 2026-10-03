modulus = 1000000007

n = input()
s = list(zip(input(), input()))

def sliding_window(it):
    it = iter(it)
    fst = next(it)
    for snd in it:
        yield fst, snd
        fst = snd

if n == 1:
    print(3)
elif n == 2:
    print(6)
else:
    ans = 0
    if s[0][0]==s[0][1]:
        ans += 3
    else:
        ans += 6
    for x in sliding_window(s):
        if x[0][0] == x[0][1]:
            ans = ans * 2 % modulus
        elif x[0][0] != x[1][0]:
            if x[1][0] != x[1][1]:
                ans = ans * 3 % modulus
    print(ans)
