_ = int(input())
a = sorted(list(map(int, input().split())), reverse=True)
l = [0,0]
c = 0
i = 0
while(i < len(a)-1):
    if(a[i] == a[i+1]):
        del l[0]
        l.append(a[i])
        i += 1
        c += 1
    if(c >= 2 or i == len(a)-2):
        i = len(a)-1
        print(l[0] * l[1])
    i += 1