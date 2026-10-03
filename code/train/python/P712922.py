import sys
S=input()
a=[]

for i in S :
    try :
        a.append(int(i))
    except :
        continue


for j in a :
    print(j,end='')
