N=int(input())
A=[str(input()) for i in range(N)]
A.sort()
name=[]
voted=[]
for i in range(N):
  if A[i] in name:
    voted[name.index(A[i])]+=1
  else:
    name+=[A[i]]
    voted+=[1]
print(name[voted.index(max(voted))])