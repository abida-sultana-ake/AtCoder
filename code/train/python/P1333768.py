N, S, T = map(int,input().split())
W = int(input())
if S <= W <= T:
    day = 1
else:
    day = 0
    
for i in range(N-1):
    A = int(input())
    W += A
    if S <= W <= T:
        day += 1
        
print(day)