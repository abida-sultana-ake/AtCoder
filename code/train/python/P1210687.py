S = input()
T = input()
q = int(input())

SA = []
SB = []
cnt_a = 0
cnt_b = 0
for s in S:
    if s == "A":
        cnt_a += 1
    else:
        cnt_b += 1
    SA.append(cnt_a)
    SB.append(cnt_b)

TA = []
TB = []
cnt_a = 0
cnt_b = 0
for t in T:
    if t == "A":
        cnt_a += 1
    else:
        cnt_b += 1
    TA.append(cnt_a)
    TB.append(cnt_b)


def check(a, b, c, d):
    sa = SA[b-1]
    sb = SB[b-1]
    if a >= 2:
        sa -= SA[a - 2]
        sb -= SB[a - 2]
    ta = TA[d-1]
    tb = TB[d-1]
    if c >= 2:
        ta -= TA[c-2]
        tb -= TB[c-2]
    """
    print(sa, sb)
    print(ta, tb)
    """

    sb += 2 * sa
    sb %= 3

    tb += 2 * ta
    tb %= 3

    return sb == tb


for i in range(q):
    a, b, c, d = map(int, input().split())
    if check(a, b, c, d):
        print("YES")
    else:
        print("NO")
