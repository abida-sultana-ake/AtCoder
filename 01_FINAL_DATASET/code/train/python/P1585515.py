S = str(input())
N = int(input())
dic = list()
for i in range(len(S)):
    for j in range(len(S)):
        dic.append(S[i] + S[j])

print(dic[N-1])
