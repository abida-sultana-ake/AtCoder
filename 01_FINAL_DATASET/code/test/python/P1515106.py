H, B = map(float, input().split())

H /= 100
ans = round((H ** 2) * B * 1000)
print(ans / 1000)
