N = int(input())
p = 0
while True:
    if N < 2**p:
        print(2**(p-1))
        break
    else:
        p=p+1
    