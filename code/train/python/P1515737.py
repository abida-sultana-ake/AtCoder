L, R = map(int, input().split())

Llist = list(map(int, input().split()))
Rlist = list(map(int, input().split()))
count = 0

for i in range(L):
    for j in range(R):
        if Llist[i] == Rlist[j] and Llist[i] != 0:
            Llist[i] = 0
            Rlist[j] = 0
            count += 1

print(count)
