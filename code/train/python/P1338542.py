s=input()
flag=0
x=[]
if(len(s)>26):
    print("no")
else:
    for i in range(len(s)):
        for j in range(i):
            if(s[i]==s[j]):
                flag=1
    if(flag==1):
        print("no")
    else:
        print("yes")