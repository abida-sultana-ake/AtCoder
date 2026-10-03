n = int(input())
A = list(map(int,input().split()))
print(' '.join(map(str,A[::-2]))+' '+' '.join(map(str,A[len(A)%2::2])))