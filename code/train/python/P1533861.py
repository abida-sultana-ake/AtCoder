xa,ya,xb,yb,xc,yc = map(int, input().split(" "))
print(abs((xa-xc)*(yb-yc)-(ya-yc)*(xb-xc))/2.0)