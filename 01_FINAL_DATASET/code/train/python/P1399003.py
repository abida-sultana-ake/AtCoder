if(__name__ =="__main__"):
    N = int(input())
    a = [int(i) for i in input().split()]
    b = [0] * 512345
    left = 212345
    right = left + 1
    for i in range(N):
        if(i % 2 == (N-1) % 2):
            #b.insert(0,a[i])
            b[left] = a[i]
            left -= 1
        else:
            #b.append(a[i])
            b[right] = a[i]
            right += 1
        #print(b)
        # b = b[::-1] TLE:O(N)    
        #print(b)
    #b.extend(a)
    #print(' '.join(map(str,b)))
    for i in range(left+1,right):
        print(b[i],end=" ")