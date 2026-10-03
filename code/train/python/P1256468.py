a, b, c = map(int, input().split())

answer = "NO"
for i in range(b):
    d = i*a
    if d%b == c:
        answer = "YES"

print(answer)