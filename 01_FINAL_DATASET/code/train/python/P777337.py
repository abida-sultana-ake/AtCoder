n = int(input())
pillar = list(map(int, input().split()))

lowest = [None] * n

lowest[0] = 0
lowest[1] = abs(pillar[0] - pillar[1])
for i in range(2,n):
    lowest[i] = min(lowest[i-1] + abs(pillar[i-1] - pillar[i]), lowest[i-2] + abs(pillar[i-2] - pillar[i]))

print(lowest[n-1])
