def wage(b,idno):
    buka = [i for i in range(n) if b[i] == idno]
    if len(buka) == 0:
        return 1
    else:
        hoge = list(map(lambda x: wage(b,x),buka))
        return max(hoge) + min(hoge) + 1

n = int(input())
b = [int(input())-1 for i in range(n-1)]
b.insert(0,-1)
print(wage(b,0))
