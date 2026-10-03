N = int(input())

C = [int(input()) for _ in range(N)]

L = [C[0]]

for c in C[1:]:
    if c > L[-1]:
        L.append(c)
    else:
        left=0
        right=len(L)-1

        while left<=right:
            mid = (left+right)//2
            if c<L[mid]:
                right=mid - 1
            else:
                left=mid + 1
        
        L[left] = c

print(N - len(L))