
ans = 0

for i in range(int(input())):
    t_i, a_i = list(map(lambda x: int(x), input().split()))

    if i == 0:
        t, a = t_i, a_i

    else:
        n = max((t + t_i - 1) // t_i, (a + a_i - 1) // a_i)
        t = n*t_i
        a = n*a_i

    ans = t + a

print(ans)
