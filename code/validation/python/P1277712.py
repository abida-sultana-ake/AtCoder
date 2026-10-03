"""
AtCoder Begginer Contest
"""
import sys
# get N, K
N, K = map(int, input().split())

# def function
def calcXor(depth, nowData):
    for choice in range(0, K):
        getData = QUEST[depth][choice]
        if depth == 0:
            calcData = getData
        else:
            calcData = nowData ^ getData
        
        # check calculation
        if depth == (N - 1):
            if calcData == 0:
                print("Found")
                sys.exit(0)
        else:
            # call function
            calcXor(depth + 1, calcData)

QUEST = list()

for i in range(0, N):
    QUEST.append(list(map(int, input().split())))

# calculation
calcXor(0, 0)
# output
print("Nothing")
