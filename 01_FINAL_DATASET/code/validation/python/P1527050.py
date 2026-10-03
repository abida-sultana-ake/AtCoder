#Make a Rectangle
N = int(input())
A = list(map(int, input().split()))

a = sorted(A, reverse=True)
b = []

i = 0
while i<N-1:
    if ( a[i]==a[i+1] ):
        b+=[a[i]]
        i+=2
    else:
        i+=1
    if (len(b)>1):
        break

if (len(b)<2):
    print(0)
else:
    print(b[0]*b[1])