N  =int(input())
l = [int(input()) for _ in range(3)]

if N in l:
    print('NO')
else:
    flag = False
    for i in range(100):
        if N <= 3:
            flag = True
            break
        elif N-3 not in l:
            N -= 3
        elif N-2 not in l:
            N -= 2
        elif N-1 not in l:
            N -= 1
        else:
            break
        
    print('YES' if flag else 'NO')