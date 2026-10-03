N = int(input())
A = [int(input()) for _ in range(N)]
A=list(set(A)) #重複を除く
A.sort(reverse=True) #降順ソート
print(A[1]) #2番めを取る