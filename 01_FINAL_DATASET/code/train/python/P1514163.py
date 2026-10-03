def gcd(x, y):
    while y != 0:
        x, y = y, x%y
    return x
    
def lcm(x, y):
    return x * y // gcd(x, y)
    
N = int(input())
T = []
for i in range(N):
    T.append(int(input()))
temp = T[0]
for i in range(N-1):
    temp = lcm(temp, T[i+1])
print(temp)