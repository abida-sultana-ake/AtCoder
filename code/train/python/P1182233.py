ab=(input())
a_,b_=ab.split()
a=int(a_)
b=int(b_)

if a+b>24:
    print(a+b-24)
elif a+b==24:
    print("0")
        
else:
    print(a+b)