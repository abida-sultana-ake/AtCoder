K = int(input())
a = [i + (K // 50) for i in range(50)]
for i in range(K % 50):
    a[49 - i] += 1
print(50)
for i in range(50):
    print(a[i], end=" ")
print()