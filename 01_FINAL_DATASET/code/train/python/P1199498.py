import math
N=int(input());xy=[list(map(int,input().split())) for _ in [1]*N]
print(max([math.sqrt((a[0]-b[0])**2+(a[1]-b[1])**2) for a in xy for b in xy]))