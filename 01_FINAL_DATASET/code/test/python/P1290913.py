#N,Tの取得
N,T = map(int, input().split())
#秒のリストを取得
tl = list(map(int, input().split()))

bt = 0 #直前のスイッチを押した時間
gt = T #秒数総和
for t in tl[1:]:
    if t - bt > T:
        gt += T #スイッチオフの時はT秒追加
    else:
        gt += t - bt #スイッチがオンのとき、前回からの経過時間を加算
    bt = t

print(str(gt))