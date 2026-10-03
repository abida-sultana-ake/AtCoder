from itertools import product

H, W, N = 0, 0, 0
filled = {}

def boundary_check(pos):
    """
    (x, y) -> bool
    """
    return pos[0] < W - 2 and pos[1] < H - 2 and pos[0] >= 0 and pos[1] >= 0

def matrix_cell_in(a, b):
    """
    int -> int -> (int, int)

    塗りつぶされたセルの座標から、そのセルが含まれる 3 * 3 連続セルの集合を返す。
    3 * 3 連続セルは左上セルの座標で表現する。
    """
    matrixes = list(product(range(a-2,a+1),(range(b-2, b+1))))
    return list(filter(boundary_check ,matrixes))
    # return matrixes

def fill(pos, cell):
    """
    (int, int) -> unit

    3 * 3連続セルの座標を受け取って、その中の黒マスの数を増やす。まだ塗られていなかった場合は 1 にする。
    """
    if pos in filled:
        filled[pos] += 1
    else:
        filled[pos] = 1


H, W, N = map(int, input().split(" "))

for i in range(N):
    b, a = map(int, input().split(" "))
    a, b = a-1, b-1
    for cell in matrix_cell_in(a,b):
        fill(cell, (a,b))

results = [0 for _ in range(10)]
for v in filled.values():
    results[v] += 1

results[0] =  (H - 2) * (W - 2)  - sum(results)

for r in results:
    print(r)