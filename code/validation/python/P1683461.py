import sys

input = sys.stdin.readline
print = sys.stdout.write

def checkmine(matrix,r,c):
    if matrix[r][c] == "#":
        return "#"

    dr = [-1,-1,-1, 0,0, 1,1,1]
    dc = [-1, 0, 1,-1,1,-1,0,1]
    
    numberOfBombs = 0
    for i in range(8):
        #if r + dr[i] > -1 and r + dr[i] < len(matrix) and c + dc[i] > -1 and c + dc[i] < len(matrix[0]):
        try:
            if matrix[r+dr[i]][c+dc[i]] == "#" and r+dr[i] > -1 and c+dc[i] > -1:
                numberOfBombs += 1
        except:
            pass
        
    return numberOfBombs

N,M = map(int,input().split())
l = []
for i in range(N):
    l.append(input())
    
for i in range(N):
    for j in range(M):
        print(str(checkmine(l,i,j)))
    print("\n")