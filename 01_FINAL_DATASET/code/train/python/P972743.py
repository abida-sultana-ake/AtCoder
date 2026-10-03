from sys import stdin
input = stdin.readline
N,T = map(int,input().split())
prices = list(map(int,input().split()))
last = 10000000000
highestTally = [prices[-1]]
highestCount = [1]

for price in prices[-2:-N-1:-1]:
    if price==highestTally[-1]:
        highestCount.append(highestCount[-1]+1)
    else:
        highestCount.append(1)
    highestTally.append(max(highestTally[-1],price))
highestTally.reverse()
highestCount.reverse()

indexOfHighest={}
for i in range(N-1,-1,-1):
    if highestTally[i]==prices[i]:
        indexOfHighest[highestTally[i]]=i

biggestJump=0
sellingPriceForBiggestJump=0
HPcount=0
LPcount=0
HPGroups=[]
LPGroups=[]
for index,price in enumerate(prices):
    if index==N-1:
        break
    bestSellingPrice = highestTally[index+1]
    jump = bestSellingPrice-price
    #print(jump,bestSellingPrice,biggestJump)
    if jump>biggestJump:
        biggestJump = jump
        #LPcount+=1
        LPGroups=[]
        HPGroups=[]
        
        LPGroups.append(1)
        sellingPriceForBiggestJump = bestSellingPrice
        #HPcount=highestCount[indexOfHighest[bestSellingPrice]]
        HPGroups.append(highestCount[indexOfHighest[bestSellingPrice]])
    elif jump==biggestJump:
        if bestSellingPrice!=sellingPriceForBiggestJump:
            sellingPriceForBiggestJump = bestSellingPrice
            #HPcount+=highestCount[indexOfHighest[bestSellingPrice]]
            HPGroups.append(highestCount[indexOfHighest[bestSellingPrice]])
            LPGroups.append(0)
        LPGroups[-1]+=1
count = 0
bs = T//2
for a,b in zip(HPGroups,LPGroups):
    if bs>min(a,b):
        count+=min(a,b)
    else:
        count+=bs
print(count)
