n=input()
l=len(set([int(x) for x in input().split()]))
print(l-(l+1)%2)