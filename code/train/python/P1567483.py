N = int(input())
words = [input() for i in range(N)]

rev = []
for i in range(len(words)):
    rev.append(words[i][::-1])

rev.sort()

for i in range(len(rev)):
    print(rev[i][::-1])