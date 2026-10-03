N=int(input())
K=int(input())
print(2*sum([ min(x,K-x) for x in map(int,input().split()) ]))