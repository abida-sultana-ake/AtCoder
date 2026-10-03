h, w, n = map(int, input().split())
a_b = [list(map(int, input().split())) for i in range(n)]

mass_dict = {}

def count_blackmass(y, x):
    # 黒マスの座標を引数として受け取る
    # その黒マスを含んでいる3*3のマスのカウントを1増やす
    # xが列yが行
    global mass_dict
    for i in range(3):
        tmpy = y - i # 黒マスを含んでいる3*3の左上の頂点のy座標
        for j in range(3):
            tmpx = x - j # 黒マスを含んでいる3*3の左上の頂点のx座標
            if 0 < tmpy and 0 < tmpx and tmpx + 2 <= w and tmpy + 2 <= h: #適切な範囲
                if  (tmpx, tmpy) in mass_dict:
                    mass_dict[(tmpx, tmpy)] += 1
                else:
                    mass_dict[(tmpx, tmpy)] = 1


count = [0 for i in range(10)]
for i, j in a_b: # O(N)
    # iが行,jが列を表している
    count_blackmass(i, j)

for val in mass_dict.values():
    count[val] += 1

count[0] = (w - 2) * (h - 2) - sum(count[1:])
for i in range(10):
    print(count[i])
