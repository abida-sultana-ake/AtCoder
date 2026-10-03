import sys
N,K = list(map(int,input().split()))
D = input().split()
while True:
    breaked = False
    for i in range(len(str(N))):
        if str(N)[i] in D:
            breaked = True
            break
    if not(breaked):
        print(N)
        sys.exit()
    N += 1