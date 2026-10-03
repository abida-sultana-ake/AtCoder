a = int(input())
b = int(input())
a1 = a
b1 = b
a2 = a
b2 = b
cnt1 = 0
cnt2 = 0

while (a1 != b1) :
    if  a1 == 9:
        a1 = 0
    else :
        a1 = a1 + 1
    cnt1 = cnt1 + 1

while (a2 != b2) :
    if  a2 == 0:
        a2 = 9
    else :
        a2 = a2 - 1
    cnt2 = cnt2 + 1

if  cnt1 > cnt2 :
    print(cnt2)

else :
    print(cnt1)
