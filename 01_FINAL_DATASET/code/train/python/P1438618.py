N = int(input())
rList = []
rDict = {}
rNum = {}
person = []

for i in range(N):
    r,h = map(int,input().split())
    if not r in rDict:
        rList.append(r)
        rDict[r] = [0,0,0]
        rNum[r] = 0
    rNum[r] += 1
    rDict[r][h-1] += 1
    person.append((r,h-1))


rList.sort()

l = len(rList)
lowRateList = [rNum[rList[i-1]] if i > 0 else 0 for i in range(l)]
for i in range(0,l-1):
    lowRateList[i+1] += lowRateList[i]
winNumList = [[lowRateList[i]+rDict[rList[i]][1],lowRateList[i]+rDict[rList[i]][2],lowRateList[i]+rDict[rList[i]][0]] for i in range(l)]
drawNumList = [[rDict[rList[i]][0]-1, rDict[rList[i]][1]-1, rDict[rList[i]][2]-1] for i in range(l)]

rListDict = {}
for i in range(l):
    rListDict[rList[i]] = i

for i in range(N):
    p = person[i]
    r,h = p[0], p[1]
    w,d = winNumList[rListDict[r]][h], drawNumList[rListDict[r]][h]
    print(w,N-w-d-1 ,d)