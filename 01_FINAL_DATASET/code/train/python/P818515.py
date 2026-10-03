n, k = map(int, input().split())
dislike = input().split()
i = 0
while True:
    money = str(n + i)
    if len(set(money).intersection(dislike)) == 0:
        print(money)
        break
    i += 1