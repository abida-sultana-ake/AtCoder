n = int(input())
count = 0

for i in range(n):
    count += (i+1)

def is_prime(n):
    for i in range(2, n):
        ans = n % i
        if ans == 0:
            return False
    return n != 1

ans = is_prime(count)
if ans == True:
    print("WANWAN")
else:
    print("BOWWOW")
