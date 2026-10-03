N=int(input())
w=input().replace('.','').split()
t=['TAKAHASHIKUN','Takahashikun','takahashikun']
print(len([i for i in w if i in t]))