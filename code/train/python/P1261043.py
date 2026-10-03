X=int(input())
if (X%400) == 0:
    print("YES")
elif (X%100) == 0:
    print("NO")
elif (X%4)  == 0:
    print("YES")
else:
    print("NO")