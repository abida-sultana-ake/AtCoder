def solve(gx,gy,A,que):
    while 1:
        n = que.pop(0)
        sc = [[n[0]-1,n[1]],[n[0],n[1]-1],[n[0]+1,n[1]],[n[0],n[1]+1]]
        for i in sc:
            if A[i[0]][i[1]] == '.':
                A[i[0]][i[1]] = A[n[0]][n[1]] + 1
                que.append([i[0],i[1]])
        if A[gx-1][gy-1] != '.':
            return A[gx-1][gy-1]
                
r,c = map(int,input().split())
sx,sy = map(int,input().split())
gx,gy = map(int,input().split())
A = [list(input())for _ in[None]*r]
que = [[sx-1,sy-1]]
A[sx-1][sy-1] = 0
print(solve(gx,gy,A,que))