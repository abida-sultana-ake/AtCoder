A = int(input())
lst1 = []
for i in range(A-1):
    lst1.append((i+1)*(A-i-1))
lst2 = sorted(lst1,reverse = True)
print(lst2[0])
