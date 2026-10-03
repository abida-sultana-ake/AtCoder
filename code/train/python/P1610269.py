src = [list(map(int,input().split())) for i in range(4)]
def solve():
    for i in range(4):
        for j in range(3):
            if src[i][j] == src[i][j+1]:
                return True
    for i in range(3):
        for j in range(4):
            if src[i][j] == src[i+1][j]:
                return True
    return False
print('CONTINUE' if solve() else 'GAMEOVER')
