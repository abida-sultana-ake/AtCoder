L = []
for i in range(3):
    L.append(int(input()))
for i in range(3):
    rank = 1
    for j in range(3):
        if i == j:
            continue
        else:
            if L[i] < L[j]:
                rank += 1
    print(rank)