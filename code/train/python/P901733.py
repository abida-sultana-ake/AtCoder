N, K = map(int, input().split())

d = input().split()

def check(c):
    for i in d:
        if str(c).count(i): return False
    return True

count = N
while True:
    if check(count): break
    count += 1
print(count)
