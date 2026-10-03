N = int(input())
min_T = 100
for i in range(N):
    T = int(input())
    if T < min_T:
        min_T = T
print(min_T)
