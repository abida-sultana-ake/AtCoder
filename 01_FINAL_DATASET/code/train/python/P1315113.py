ipt = input().split()

a = [1, 3, 5, 7, 8, 10, 12]
b = [4, 6, 9, 11]
i=int(ipt[0])
j=int(ipt[1])
if i==j:
    print('Yes')
elif i in a and j in a:
    print('Yes')
elif i in b and j in b:
    print('Yes')
else:
    print('No')
                

    