
N, T = map(int, input().split())
t = list(map(int, input().split()))
sum = 0
end = 0
for i in range(N):
    sum += T - max(0, end - t[i])
    end = t[i] + T

print(sum)

