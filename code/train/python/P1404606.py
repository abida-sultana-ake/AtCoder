import numpy as np


def can_put(i, j, board):
    if np.sum(board, axis=0)[j]:
        return False
    if np.sum(board.diagonal(j - i)):
        return False
    if np.sum(np.rot90(board, 3).diagonal(7 - i - j)):
        return False
    return True


def solve(i, board):
    if i > 7:
        return True
    if np.sum(board, axis=1)[i]:
        return solve(i + 1, board)
    for j in range(8):
        if can_put(i, j, board):
            board[i][j] = 1
            if solve(i + 1, board):
                return True
            board[i][j] = 0
    return False


def first_put(board):
    for i in range(8):
        for j, c in enumerate(input().strip()):
            if c == 'Q':
                if can_put(i, j, board):
                    board[i][j] = 1
                else:
                    return False
    return True


def print_board(board):
    for i in range(8):
        for j in range(8):
            print('Q' if board[i][j] else '.', end='')
        print()


board = np.zeros((8, 8))
if first_put(board) and solve(0, board):
    print_board(board)
else:
    print('No Answer')
