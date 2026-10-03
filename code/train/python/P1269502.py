N=int(input())
Alist=[]
Blist=[]
flag=0

words=[]

for a in range(N):
    words.append(input())

for a in range(N):
    word = words[a]
    if a==0:
        pre = word[0]
    if a%2 == 0:
        if (word in Alist) or word[0]!=pre :
            print('LOSE')
            flag=1
            break
        else:Alist.append(word)
    else:
        if (word in Alist) or word[0]!=pre :
            print('WIN')
            flag=1
            break
        else:Alist.append(word)
    pre = word[len(word)-1]

if flag==0:
    print('DRAW')