a=int(input())
b=int(input())

if a%b == 0:
    print ("0")
else:
    c = b-a%b
    print(str(c))