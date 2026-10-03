A,B,C=map(str,input().split())
if (A[-1:]==B[:1] and B[-1:]==C[:1]):
    print("YES")
else:
    print("NO")