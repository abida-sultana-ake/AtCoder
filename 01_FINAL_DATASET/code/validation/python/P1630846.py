from collections import deque
import operator
moveList=[[0,-1],[0,1],[-1,0],[1,0]]
def twoDimArray(row,column,n): return [[n for j in range(column)] for i in range(row)]
def bfs(queueList,func):
    queue = deque()
    queue.extend(queueList)
    while len(queue) != 0:
        elem = queue.popleft()
        queue.extend(func(elem))
        
r,c = map(int, input().split())
sy,sx =map(int, input().split())
gy,gx =map(int, input().split())
matrix = [list(input()) for i in range(r)]
yxbanmen=twoDimArray(r,c,10000)

"""
番兵
"""
road ='.'
def mazeSearch(x:tuple):
    ans =[]
    val=x[2]
    yx=[x[0],x[1]]
    for i in moveList:
        movedCell = list(map(operator.add,yx,i))
        if (matrix[movedCell[0]][movedCell[1]]==road) and (yxbanmen[movedCell[0]][movedCell[1]]>val+1):
            yxbanmen[movedCell[0]][movedCell[1]]=val+1
            ans.append((movedCell[0],movedCell[1],val+1))
            if movedCell[0]==gy-1 and movedCell[1]==gx-1:
                print(val+1)
                exit()
    return ans  
bfs([(sy-1,sx-1,0)],mazeSearch)