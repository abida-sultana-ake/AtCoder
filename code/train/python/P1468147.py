k = int(input())
if k <= 100 * 1000:
    if k % 2:
        print(2)
        print(k // 2, 2 + k // 2)
    else:
        print(2)
        print(1 + k // 2, 1 + k // 2)
else:
    mn = k // 50
    md = k % 50
    print(50)
    ok = 49 + mn
    for i in range(50):
        if i < md:
            print(ok + 50 - (md - 1), end=" ")
        else:
            print(ok - md, end= " ")
