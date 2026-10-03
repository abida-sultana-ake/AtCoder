N = int(input())

li = list(map(int, input().split()))
li.sort()
li.reverse()

saki = sum(li[::2])
ato = sum(li[1::2])

print(saki)
