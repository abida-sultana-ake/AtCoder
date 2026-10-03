N = int(input())
li = [input() for i in range(N)]
word = []
lose = 0

for i in range(N):
    a = li[i]
    if len(word) == 0:
        word.append(a)
        last = a[-1:]
    else:
        ans = a in word
        if ans == True:
            lose = i
            break
        if last != a[0:1]:
            lose = i
            break
        word.append(a)
        last = a[-1:]
        
if lose == 0:
    print("DRAW")
elif lose % 2 == 1:
    print("WIN")
else:
    print("LOSE")
