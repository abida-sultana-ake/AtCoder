def C_Dictionary(N, K, S):
    def count_unmatch(S, T, c):
        # 文字列Tに文字cを追加したときの、Sと一致しない文字の数
        # Tの決定済(長さl)の部分について、Sの先頭から長さlの部分文字列
        s_done = S[:len(T) + 1]
        t_done = T + c
        count = 0

        # 決定済みの文字列における不一致の数
        for i in range(len(s_done)):
            if s_done[i] != t_done[i]:
                count += 1

        # 未決定の部分について
        # Sのうちt_doneの要素として使っていないものを要素とする文字列をt、
        # S = s_done + s となるようにした「あまり」の文字列をsとする.
        match = 0  # s,tで一致させられる文字の数
        for i in range(ord('a'), ord('a') + 26):
            c = chr(i)  # 文字aからzの順に調べる
            # sの中にあるcの数,tの中にあるcの数、どちらが少ないか？
            match += min(S.count(c) - s_done.count(c),
                         S.count(c) - t_done.count(c))
        # 未決定の文字列の中の不一致の数 = 未決定の文字列長 - match
        count += (N - len(T) - 1) - match
        return count

    S_order = sorted(S)
    T = ""
    for i in range(N):
        for c in S_order:
            if count_unmatch(S, T, c) <= K:
                T = T + c
                S_order.remove(c)
                break
    return T
  
N, K = [int(i) for i in input().split()]
S = input()
print(C_Dictionary(N, K, S))