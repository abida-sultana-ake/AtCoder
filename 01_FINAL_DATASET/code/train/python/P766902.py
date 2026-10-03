W, H = map(int, input().split())
print(("16:9", "4:3")[W // 4 == H // 3])