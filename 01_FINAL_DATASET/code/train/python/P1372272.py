n = int(input())
words = [input() for i in range(n)]
for idx, x in enumerate(words):
    x = x[::-1]
    words[idx] = x
words.sort()
for idx, x in enumerate(words):
    x = x[::-1]
    print(x)
