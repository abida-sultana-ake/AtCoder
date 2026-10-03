H, W = map(int, input().split())
inp = []
for h in range(H):
    inp.append(input())
dd = [(-1, -1), (-1, 0), (-1, 1), (1, -1), (1, 0), (1, 1), (0, -1), (0, 1)]
change_pos = []
for h in range(H):
    for w in range(W):
        if inp[h][w] == ".":
            continue
        for i in range(8):
            n_h = h + dd[i][0]
            n_w = w + dd[i][1]
            if 0 <= n_h < H and 0 <= n_w < W:
                if inp[n_h][n_w] != "#":
                    break
        else:
            change_pos.append((h, w))
orig = [["." for w in range(W)] for h in range(H)]
ans_table = [["." for w in range(W)] for h in range(H)]
for cp in change_pos:
    orig[cp[0]][cp[1]] = "#"
    ans_table[cp[0]][cp[1]] = "#"
    for i in range(8):
        n_h = cp[0] + dd[i][0]
        n_w = cp[1] + dd[i][1]
        if 0 <= n_h < H and 0 <= n_w < W:
            orig[n_h][n_w] = "#"
ans = True
for h in range(H):
    for w in range(W):
        if inp[h][w] != orig[h][w]:
            ans = False
            break
    if not ans:
        break
if ans:
    print("possible")
    for h in range(H):
        print("".join(ans_table[h]))
else:
    print("impossible")
