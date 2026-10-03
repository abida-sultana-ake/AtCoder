N = int(input())
l, r, ans, s = 0, 0, 0, set()
add, remove = s.add, s.remove
a = tuple(map(int, input().split()))
while r < N:
    if len(s) > ans:
        ans = len(s)
    if a[r] in s:
        while a[r] in s:
            remove(a[l])
            l += 1
    else:
        add(a[r])
        r += 1
print(max(ans, len(s)))