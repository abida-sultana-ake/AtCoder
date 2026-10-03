n = int(input())
xs = list(map(int, input().split()))
ys = xs[-1::-2] + xs[n%2::2]
print(*ys)