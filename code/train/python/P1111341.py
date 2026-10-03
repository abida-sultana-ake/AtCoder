s=input()
for _ in [0]*int(input()):
    a,b=map(int,input().split())
    a-=1
    s=s[:a]+s[a:b][::-1]+s[b:]
print(s)