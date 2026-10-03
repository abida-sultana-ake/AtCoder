M = list(map(str, input()))
l = len(M) - 1
count = 0
array = []
for i in range(l):
    if M[i] == M[i + 1]:
        count += 1
        if i + 1 == l:
            count += 1
            array.append(M[i + 1])
            array.append(count)
    elif M[i] != M[i + 1]:
        count += 1
        array.append(M[i])
        array.append(count)
        count = 0
        if i + 1 == l:
            count += 1
            array.append(M[i + 1])
            array.append(count)
ans = "".join(map(str, array))
print(ans)
