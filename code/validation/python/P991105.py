n=int(input())
a=[int(i) for i in input().split()]
for i in sorted(range(n),key=lambda x:a[x],reverse=True):
    print(i+1)
