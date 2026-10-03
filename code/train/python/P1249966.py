A, B, C = list(map(int, input().split()))

mod_list = []
i = 1
while True:
    mod = (A * i) % B
    if mod in mod_list:
        break
    mod_list.append(mod)
    i += 1

if C in mod_list:
    print("YES")
else:
    print("NO")


