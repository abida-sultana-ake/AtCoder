S = input().lower()
N = len(S)
target = 'ict'

def solve():
    i = 0
    for c in S:
        if c == target[i]:
            i += 1
            if i == 3:
                return True
    return False

print('YES' if solve() else 'NO')
