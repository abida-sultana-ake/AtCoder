N = int(input())
T = list(map(int, input().split()))
max = sum(T)
M = int(input())
for i in range(M):
    P, X = map(int, input().split())
    diff = X - T[P - 1]
    print(max + diff) 
    