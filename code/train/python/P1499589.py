n = int(input())
As = list(map(int , input().split()))
cnt = 0

for a in As:
    
    while True:
        if (a%3 == 2) or (a%2 ==0):
            a -= 1
            cnt += 1
        else:
            break

print(cnt)
    