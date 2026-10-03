DIC = list(input().split())
REV = []
for i in range(10):
    REV.append(str(DIC.index(str(i))))

def encode(n):
    li = list(str(n))
    for i in range(len(li)):
        li[i] = REV[int(li[i])]
    return(int(''.join(li)))

def decode(n):
    li = list(str(n))
    for i in range(len(li)):
        li[i] = DIC[int(li[i])]
    return(int(''.join(li)))

N = int(input())
arr = []
for i in range(N):
    a = int(input())
    arr.append(encode(a))

arr.sort()

for a in arr:
    print(decode(a))
