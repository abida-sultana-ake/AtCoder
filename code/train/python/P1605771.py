s=0;a={}
for v,k in[input().split() for i in[0]*int(input())]:s+=int(k);a[k]=v
k=sorted(a,key=int)[-1];print(["atcoder",a[k]][2*int(k)>s])