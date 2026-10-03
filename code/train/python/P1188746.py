N=int(input())
wordList=[input()[::-1] for i in range(N)]
wordList.sort()
for w in wordList: print(w[::-1])