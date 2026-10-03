a, b, c = map(int,input().split(' '))
n = 1
mod = []
while(True):
    if (a * n) % b == c:
        print("YES")
        break
    else:
        if (a * n) % b not in mod:
            mod.append((a * n) % b)
        else:
            print("NO")
            break
    n += 1
