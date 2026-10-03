N, A, B = map(int, input().split())
D = A - B

H = [int(input()) for _ in range(N)]

def f(n):
    needed_attacks = 0
    for h in H:
        r = h - B * n
        if r < 0:
            r = 0

        if r % D == 0:
            needed_attacks += r // D
        else:
            needed_attacks += r // D + 1

    return needed_attacks <= n

s = 0
e = max(H) // B + 1

while e - s > 1:
    m = (s + e) // 2
    if f(m):
        e = m
    else:
        s = m

print(e)
