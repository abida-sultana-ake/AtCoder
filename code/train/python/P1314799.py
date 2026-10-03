N = int(input())
price = 0

for i in range(N):
    a,b = map(int,input().split())
    price += a * b
    
print(price * 105 // 100)