def calc(board,b,c,ms):
    ret = -ms
    if (board[0*3+0] == board[1*3+0]): ret += 2*b[0]
    if (board[0*3+1] == board[1*3+1]): ret += 2*b[1]
    if (board[0*3+2] == board[1*3+2]): ret += 2*b[2]
    if (board[1*3+0] == board[2*3+0]): ret += 2*b[3]
    if (board[1*3+1] == board[2*3+1]): ret += 2*b[4]
    if (board[1*3+2] == board[2*3+2]): ret += 2*b[5]
    if (board[0*3+0] == board[0*3+1]): ret += 2*c[0]
    if (board[0*3+1] == board[0*3+2]): ret += 2*c[1]
    if (board[1*3+0] == board[1*3+1]): ret += 2*c[2]
    if (board[1*3+1] == board[1*3+2]): ret += 2*c[3]
    if (board[2*3+0] == board[2*3+1]): ret += 2*c[4]
    if (board[2*3+1] == board[2*3+2]): ret += 2*c[5]
    return ret

def dai(board,count,b,c,ms):
    score = -10000
    for i in range(9):
        if board[i] != 0: continue
        board[i] = 1
        score = max(score, ko(list(board),count,b,c,ms))
        board[i] = 0
    return score

def ko(board,count,b,c,ms):
    if count == 5: return calc(board,b,c,ms)
    score = 10000
    for i in range(9):
        if board[i] != 0: continue
        board[i] = -1
        score = min(score,dai(list(board),count+1,b,c,ms))
        board[i] = 0
    return score

def main():
    board = [0]*9
    b = list(map(int,input().split()))
    b.extend(list(map(int,input().split())))
    c = list(map(int,input().split()))
    c.extend(list(map(int,input().split())))
    c.extend(list(map(int,input().split())))
    score = 0
    for i in range(6):
        score += b[i] + c[i]
    sa = dai(board,1,b,c,score)
    dais = (score + sa)//2
    kos = (score - sa)//2
    print(dais)
    print(kos)

main()
