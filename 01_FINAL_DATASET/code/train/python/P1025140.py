H, W = map(int,input().split())

C = list()

for i in range(H):

    IN_string = input()

    for j in range(2):
        C.append(IN_string)

for i in range(2*H):
    print(C[i])