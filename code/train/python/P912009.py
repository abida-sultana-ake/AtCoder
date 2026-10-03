

inpt = input().split(" ")

maxNum = inpt[0]

dislike = input().split(" ")
dislike = [int(a) for a in dislike]

likeArray = []

for i in range(0,10):
    if not i in dislike:
        likeArray.append(i)

ans = ""
flag = False
for c in maxNum:
    if flag :
        ans += str(min(likeArray))
    else:
        if int(c) in likeArray:
            ans += c
        elif len([a for a in likeArray if a > int(c)])>0:
            ans += str(min([a for a in likeArray if a > int(c)]))
            flag = True
        else:
            ans = str(min([a for a in likeArray if a > 0]))
            for i in range(0, len(maxNum)):
                ans += str(min(likeArray))
            break    
print(ans)