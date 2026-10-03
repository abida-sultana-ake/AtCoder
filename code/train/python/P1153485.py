NK = input().split()
N = int(NK[0])
K = int(NK[1])

print( ((N-K)*(K-1)*6 + (N-1)*3 + 1) / (N ** 3) )