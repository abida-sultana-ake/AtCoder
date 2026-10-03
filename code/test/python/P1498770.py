N = int(input())
T = list(map(int, input( ).split( ) ) )
T_sum=sum(T)
M = int(input())
for m in range(M):
    p,x = map(int, input( ).split( ) )
    print(T_sum -T[p-1]+x)