import sys
N = int(input())
NG = [int(input()) for i in range(3)]
cnt = 100

if N in NG:
    print("NO")
    sys.exit()
    
while N > 3:

    if not (N - 3) in NG:
        N -=3
        
    elif not (N - 2) in NG:
        N -=2
    
    elif not (N - 1) in NG:
        N -= 1
        
    else:
        print("NO")
        sys.exit()
    
    cnt -= 1
    
    
if cnt > 0:
    print("YES")
else:
    print("NO")