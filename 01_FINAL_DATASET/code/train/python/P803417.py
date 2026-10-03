S = input()
T = int(input())

x = S.count("R") - S.count("L")
y = S.count("U") - S.count("D")
move = S.count("?")

if T == 1:
    if x < 0:
        x -= move
    else:
        x += move
    print(abs(x) + abs(y))
else:
    """
    dx = min(move, abs(x))
    if dx < move:
        remain = move - dx
        dy = min(move, abs(y))
    else:
        dy = 0
    if x < 0:
        x += dx
    else:
        x -= dx
    if y < 0:
        y += dy
    else:
        y -= dy
    print(abs(x) + abs(y))
    """
    init_move = abs(x) + abs(y)
    if move <= init_move:
        print(max(abs(x) + abs(y) - move, 0))
    else:
        if (move - init_move) % 2 == 0:
            print(0)
        else:
            print(1)
