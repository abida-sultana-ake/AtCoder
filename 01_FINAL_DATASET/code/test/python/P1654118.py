N = int(input())
dic = {}
for i in range(N):
    s = input()
    if (s in dic) == False:
        dic[s] = 1
    else:
        dic[s] += 1

dic_inv = {v:k for k, v in dic.items()}
lst = list(dic.values())
lst.sort()
lst.reverse()
print(dic_inv[lst[0]])