N = int(input())
B = [0,0]+[int(input()) for i in range(N-1)]
s = [[0,0] for i in range(N+1)]
for i in range(N, 1, -1):
    salary = sum(s[i])+1
    boss = B[i]
    s[boss] = [max(s[boss][0], salary), min(s[boss][1], salary) if s[boss][1]>0 else salary]
print(sum(s[1])+1)