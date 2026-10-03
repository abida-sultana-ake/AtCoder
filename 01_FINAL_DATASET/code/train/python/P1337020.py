N, K = map(int, input().split())
init_s = list(input())

def calc(s):
    return sum((init_s[i]!=s[i] for i in range(N)))

def sort_suf(c, odd):
    if c:
        odd.remove(c)
    n = len(odd)
    a, s = [None]*n, sorted(odd, reverse=1)
    for i in range(n):
        if init_s[i+(N-n)] in s:
            a[i] = init_s[i+(N-n)]
            s.remove(a[i])
    for i in range(n):
        if a[i] is None:
            a[i] = s.pop()
    return a

decided = []
odd = init_s[:]
for i in range(N):
    for c in sorted(odd):
        a = decided + [c] + sort_suf(c, odd[:])
        if calc(decided + [c] + sort_suf(c, odd[:])) <= K:
            decided.append(c)
            odd.remove(c)
            break
print("".join(decided))