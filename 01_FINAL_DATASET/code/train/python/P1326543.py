n = int(input())
s=[]
isten=0
score=0
for i in range(n):
    si = int(input())
    s.append(si)
    if si%10!=0:
        isten=1

s.sort()
if isten==1:
    score=sum(s)
i=0
while score%10==0 and isten==1:
    s_ = list(s)
    del s_[i]
    i+=1
    score=sum(s_)

print(score)
