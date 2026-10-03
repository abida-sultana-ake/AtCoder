a = input().split()
for i in range(len(a)):
    a[i] = int(a[i])
    
if a[0]*a[1] > a[2]*a[3]:
    print(a[0]*a[1])
else:
    print(a[2]*a[3])