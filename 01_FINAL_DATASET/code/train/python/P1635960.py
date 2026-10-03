class Board(object):
    
    def __init__(self):
        self.board = [
            [0, 0, 0, 0, 0, 0, 0, 0],
            [0, 0, 0, 0, 0, 0, 0, 0],
            [0, 0, 0, 0, 0, 0, 0, 0],
            [0, 0, 0, 0, 0, 0, 0, 0],
            [0, 0, 0, 0, 0, 0, 0, 0],
            [0, 0, 0, 0, 0, 0, 0, 0],
            [0, 0, 0, 0, 0, 0, 0, 0],
            [0, 0, 0, 0, 0, 0, 0, 0]
        ]
        self.count_row = [0] * 8
        self.count_col = [0] * 8
        self.count_diag_s = [0] * 15
        self.count_diag_d = [0] * 15
    
    def put_Q(self, r, c):
        assert self.board[r][c] == 0
        self.board[r][c] = 1
        self.count_row[r] += 1
        self.count_col[c] += 1
        self.count_diag_s[r + c] += 1
        self.count_diag_d[r - c + 7] += 1
    
    def remove_Q(self, r, c):
        assert self.board[r][c] == 1
        self.board[r][c] = 0
        self.count_row[r] -= 1
        self.count_col[c] -= 1
        self.count_diag_s[r + c] -= 1
        self.count_diag_d[r - c + 7] -= 1
    
    def is_acceptable(self):
        if max(self.count_row) > 1: return False
        if max(self.count_col) > 1: return False
        if max(self.count_diag_s) > 1: return False
        if max(self.count_diag_d) > 1: return False
        return True
    
    def can_put_Q(self, r, c):
        return self.board[r][c] == 0
    
    def __str__(self):
        str_lines = []
        for line in self.board:
            str_line = ''
            for cell in line:
                if cell == 1:
                    str_line += 'Q'
                else:
                    str_line += '.'
            str_lines.append(str_line)
        return '\n'.join(str_lines)


class ARC001C(object):
    
    @classmethod
    def solve(cls, board):
        res = cls.solve_r(board, 0)
        if res:
            return str(res)
        else:
            return 'No Answer'
    
    @classmethod
    def solve_r(cls, board, r):
        if not board.is_acceptable():
            return None
        
        if r > 7:
            return board
        
        if board.count_row[r] > 0:
            return cls.solve_r(board, r + 1)
        
        for c in range(8):
            if board.can_put_Q(r, c):
                board.put_Q(r, c)
                if cls.solve_r(board, r + 1):
                    return board
                board.remove_Q(r, c)
        return None


if __name__ == '__main__':
    board = Board()
    for r in range(8):
        line = input()
        for c in range(8):
            if line[c] == 'Q':
                board.put_Q(r, c)
    res = ARC001C.solve(board)
    print(res)
