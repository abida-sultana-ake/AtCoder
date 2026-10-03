N, M, A, B = map(int, input().split())
m=0
for x in range(M):
    m+=1
    if N <= A:
        N+=B
    N-=int(input())
    if N<0:
        break
    

print("complete" if N>=0 else m)