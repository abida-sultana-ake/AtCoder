n,k=map(int,raw_input().split())
D=map(int,raw_input().split())
while 1:
    cnt=0
    for i in str(n):
        if int(i) in D:break
        else:
            cnt+=1
    if cnt==len(str(n)):
        print(n)
        quit()
    n+=1