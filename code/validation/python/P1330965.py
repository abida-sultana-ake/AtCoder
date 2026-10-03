# coding: UTF-8
# atCoder BeginnerContest 007
# C 幅優先探索

# 幅優先探索
def breadthFirstSearch(board, start, goal):
    minReachNum = 0  # 最短手数
    # スタート地点を0にする
    board[start[0]][start[1]] = minReachNum
    targetLoc = []  # minReachNum 回で到達できる座標リスト
    confirmLoc = []  # minReachNum+1 回で到達できる座標リスト
    targetLoc.append(start)
    # ゴールの座標の最短手数が決まるまでループ
    while True:
        minReachNum += 1
        # 最短手数が確定している座標の隣接座標を調べる
        for target in targetLoc:
            # target の隣接座標のリストを作成
            adjacent = [[target[0] - 1, target[1]], [target[0] + 1, target[1]], [target[0], target[1] - 1],
                        [target[0], target[1] + 1]]
            # 隣接座標が壁でないときは現在の最小手数を board にセット
            for adj in adjacent:
                if board[adj[0]][adj[1]] == ".":
                    board[adj[0]][adj[1]] = minReachNum
                    confirmLoc.append(adj)  # minReachNum 回で到達できる座標を confirmLoc へ追加
        del targetLoc[:]
        targetLoc.extend(confirmLoc)
        del confirmLoc[:]
        # ゴールの座標の手数が確定したら終了！
        if boardMatrix[goal[0]][goal[1]] != ".":
            break

    return minReachNum


# 標準入力読み込み
# 縦横の長さ
lcLength = input().split(" ")
lineNum = int(lcLength[0])
columnNum = int(lcLength[1])
# スタート、ゴール座標
startLoc = input().split(" ")
goalLoc = input().split(" ")
# スタート、ゴール座標補正
startLoc = [int(startLoc[0]) - 1, int(startLoc[1]) - 1]
goalLoc = [int(goalLoc[0]) - 1, int(goalLoc[1]) - 1]

# 盤面
boardMatrix = []
for i in range(lineNum):
    boardMatrix.append(list(input()))

# 幅優先探索する
minReachNum = breadthFirstSearch(boardMatrix, startLoc, goalLoc)

# 結果を標準出力へ
print(minReachNum)
