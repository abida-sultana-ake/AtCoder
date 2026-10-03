li = list(map(str, input().split()))
li = [list(_) for _ in li]

if li[0].pop() == li[1][0] and li[1].pop() == li[2][0]:
        print("YES")
else:
        print("NO")
