N = int(input())
print('{:02d}:{:02d}:{:02d}'.format(N // 60 // 60, N // 60 % 60, N % 60))
