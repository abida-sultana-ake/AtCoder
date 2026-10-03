n, d, k = map(int, input().split())
left = [0] * (d + 1)
right = [0] * (d + 1)

for i in range(1, d + 1):
    l, r = map(int, input().split())
    left[i] = l
    right[i] = r

for _ in range(k):
    s, t = map(int, input().split())
    mflag = False
    if s < t:
        for i in range(1, d + 1):
            if left[i] <= s < right[i]:
                s = right[i]
            if t <= s:
                print(i)
                break
    else:
        for i in range(1, d + 1):
            if left[i] < s <= right[i]:
                s = left[i]
            if s <= t:
                print(i)
                break
