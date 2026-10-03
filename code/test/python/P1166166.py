N = int(input())
w = input().split()
w[-1] = w[-1].rstrip('.')

taka = 'takahashikun'
ans = 0

for word in w:
    if word == taka or word == taka.upper() or word == taka.capitalize():
        ans += 1

print(ans)