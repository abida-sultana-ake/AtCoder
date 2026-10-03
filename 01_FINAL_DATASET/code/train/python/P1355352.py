H,W=map(int,input().split())
A=[]

for i in range(H):
    A.append(input())

print("#"*(W+2))
for i in range(H):
    print("#"+A[i]+"#")
print("#"*(W+2))