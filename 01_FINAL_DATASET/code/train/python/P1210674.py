o = list(input())
e = list(input())

for i in range(len(e)):
        print(o[i],e[i],sep="",end="")

if len(e)<len(o):
        print(o[len(o)-1])

print("")
