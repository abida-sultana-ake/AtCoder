x,a,b=map(int,input().split())
A,B=abs(x-a),abs(x-b)
if A<B:
    print("A")
if B<A:
    print("B")