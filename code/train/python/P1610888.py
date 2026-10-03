N = int(input())
a = [list(map(int, input().split())) for i in range(N)]
print(int(sum([a[i][0]*a[i][1]*1.05 for i in range(N)])))