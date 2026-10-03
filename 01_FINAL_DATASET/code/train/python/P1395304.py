def hantei(list_str,n):
    k = int(n/2)
    if list_str[0:k] == list_str[k:n]:
        return n
    else:
        return 0
S = list(input())
length = len(S)
flag = 0
if length == 2:
    print(0)
    flag = 1
elif length == 3:
    length -= 1
    ans = hantei(S,2)
    print(ans)
    flag = 1
elif length % 2 == 1:
    length -= 1
    ans = 0
else:
    length -= 2
    ans = 0
while length >= 2:
        ans = hantei(S,length)
        if ans != 0:
            break
        length -= 2

if flag == 0:
    if ans == 0:
        print(1)
    else:
        print(ans)
