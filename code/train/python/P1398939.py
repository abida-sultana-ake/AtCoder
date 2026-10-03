if(__name__ =="__main__"):
    N = int(input())
    a =[int(i) for i in input().split()]
    b = []
    for i in range(N-1,-1,-2):
        b.append(a.pop(i))
        #print(b)
        # b = b[::-1] TLE:O(N)    
        #print(b)
    b.extend(a)
    print(' '.join(map(str,b)))