N = int(input())
a = sorted(zip(map(int, input().split()), range(N)))[::-1]
[print(i + 1) for e, i in a]