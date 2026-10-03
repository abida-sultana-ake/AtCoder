from collections import defaultdict
from operator import itemgetter
 
nums = [int(x) for x in input().split()]
R,C,K = nums[0],nums[1],nums[2]
N = int(input())
 
Sx = [0 for i in range(R)]
Sy = [0 for i in range(C)]
 
if __name__ == '__main__':

    L = []
    for i in range(N):
        nums = [int(x) for x in input().split()]
        r,c = nums[0]-1,nums[1]-1
        L.append((r,c))
        Sx[r] += 1
        Sy[c] += 1
        
    a_row2 = sorted([(j,i) for i,j in enumerate(Sx) if j <= K], key = itemgetter(0))
    a_col2 = sorted([(j,i) for i,j in enumerate(Sy) if j <= K], key = itemgetter(0), reverse=1)
 
    result = 0
    for i in range(K+1):
        r,c = 0,0
        while a_row2 and a_row2[-1][0] == K-i:
            a_row2.pop()
            r += 1
        while a_col2 and a_col2[-1][0] == i:
            a_col2.pop()
            c += 1
        result += r * c
 
    for l in L:
        s = Sx[l[0]] + Sy[l[1]]
        result += -1 if s==K else 1 if s==K+1 else 0
    print(result)