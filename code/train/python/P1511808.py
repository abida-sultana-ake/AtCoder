lst1 = list(input())
lst2 = []
n = int(input())

for i in range(5):
    for j in range(5):
        lst2.append(lst1[i] + lst1[j])
print(lst2[n-1])