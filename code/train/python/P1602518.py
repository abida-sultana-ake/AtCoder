def C(T, N, A, M, B):
    """
    T:作成されたたこ焼きのタイムリミット
    N:たこ焼きの総数
    A:たこ焼きが焼きあがった時刻
    M:客の総数
    B:客が来た時刻
    """
    ans = 'yes'
    for i in B:  # 客の来る時刻に対して
        for j in range(i - T, i + 1):
            if j in A:  # 客の来る時刻からT秒前にできたたこやきがあるか？
                A.remove(j)  # あれば、それを出せばよい
                break
            else:
                if j == i:
                    # 出せるたこやきがなかった
                    ans = 'no'
    return ans

T = int(input())
N = int(input())
A = [int(i) for i in input().split()]
M = int(input())
B = [int(i) for i in input().split()]
print(C(T, N, A, M, B))