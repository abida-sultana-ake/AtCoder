N = int(input())
A = list(map(int, input().split()))
ans = []
for idx,x in enumerate(A):
    ans.append([-x, idx])
ans.sort()
for x in ans:
    print (x[1] + 1)
    
