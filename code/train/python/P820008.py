#coding: utf-8

inputs = map(int, raw_input().split())
n = inputs[0]
k = inputs[1]
d = map(int, raw_input().split())
p = []

p.append(n//10000)
p.append(n//1000 - p[0]*10)
p.append(n//100 - p[0]*100 - p[1]*10)
p.append(n//10 - p[0]*1000 - p[1]*100 - p[2]*10)
p.append(n%10)

topindex = 0

for i in range(5):
    if p[i] != 0:
        topindex = i
        break

    
while True:
    dex = 0
    for i in range(topindex,5):
        if p[i] in d:
            dex = 1
    if dex == 1:
        n += 1
        p = []
        p.append(n//10000)
        p.append(n//1000 - p[0]*10)
        p.append(n//100 - p[0]*100 - p[1]*10)
        p.append(n//10 - p[0]*1000 - p[1]*100 - p[2]*10)
        p.append(n%10)

        topindex = 0

        for i in range(5):
            if p[i] != 0:
                topindex = i
                break
    else:
        break

print(n)