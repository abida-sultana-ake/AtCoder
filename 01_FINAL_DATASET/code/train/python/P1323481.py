import sys
S=str(input())
S_list=list(S)
S_list.sort()
l=len(S_list)

for i in range(l-1):
  if S_list[i]==S_list[i+1]:
    print("no")
    sys.exit()
print("yes")