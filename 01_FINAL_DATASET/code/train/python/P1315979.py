N = int(input())

for i in range(2, int(N ** 0.5) + 1):
    if N % i == 0 or N & 1 == 0:
        print("NO");exit()
        
print("YES")