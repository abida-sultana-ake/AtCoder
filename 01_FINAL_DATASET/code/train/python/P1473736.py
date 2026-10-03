N = int(input())
ans = 1
if (N >= 64):
    ans = 64
elif (N >= 32):
    ans = 32
elif (N >= 16):
    ans = 16
elif (N >= 8):
    ans = 8
elif (N >= 4):
    ans = 4
elif (N >= 2):
    ans = 2
print(ans)
