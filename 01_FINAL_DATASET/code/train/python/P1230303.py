n=input().split()
a=abs(int(n[0]))
b=abs(int(n[1]))
if a==b:
    print("Draw")
elif a<b:
    print("Ant")
else :
    print("Bug")