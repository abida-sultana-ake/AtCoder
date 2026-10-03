N, T = map(int, input().split())
ti = input().split()

sum = T
for i in range(1, N):
    if (int(ti[i]) - int(ti[i-1])) <= T:
        sum += (int(ti[i]) - int(ti[i-1]))
    else:
        sum += T

print(sum)
