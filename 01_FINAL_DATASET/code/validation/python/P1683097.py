import sys
H,W = input().split()
H,W = int(H),int(W)
board = [["0" for w in range(W+2)] for h in range(H+2)]

for h in range(H):
    tmp = list(input())
    for w in range(W):
        board[h+1][w+1] = tmp[w]

ansboard = [["." for w in range(W+2)] for h in range(H+2)]

for h in range(H+2):
    for w in range(W+2):
        if board[h][w] == 0:
            pass
        elif board[h][w] == ".":
            counter = 0
            for j in range(3):
                for i in range(3):
                    if board[h-(j-1)][w-(i-1)] == "#":
                        counter += 1
            ansboard[h][w] = counter
        else:
            ansboard[h][w] = "#"

for h in range(H):
    for w in range(W):
        sys.stdout.write(str(ansboard[h+1][w+1]))
    sys.stdout.write("\n")


