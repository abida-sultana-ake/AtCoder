S = str(input())
list_S = []

for i in range(len(S)):

    list_S.append(S[i:i+1])



alf = 'abcdefghijklmnopqrstuvwxyz'
list_alf = []
for i in range(len(alf)):
    list_alf.append(alf[i:i+1])

count = 0
conti = 0

for i in range(len(alf)):
    count = list_S.count(list_alf[i])
    if count == 0:
        print (list_alf[i])
        break
    conti += 1


if conti >= 26:
    print ('None')