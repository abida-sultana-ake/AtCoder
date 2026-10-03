#!/usr/bin/env python3
# -*- coding: utf-8 -*-

"""atcoder ARC007 D

初項を最小にするという条件があるため解は案外限定される。
先頭が0でないなら初項は先頭から後続の0まで。
先頭が0なら先頭に1を付加して同様に考えればよい。

これで初項が決まるので、後は第2項を短い候補から順に試していけばよい。

第2項が末項となる場合、末尾に数字を追加しなければならない可能性あり。
例えば:
  10021: 末尾に0を追加
  20020: 末尾に1を追加
"""

def seconds(S, i):
    for j in range(i+1, len(S)):
        if j != "0":
            yield j, int(S[i:j])
    yield len(S), int(S[i:])

def is_ok(S, j, a2, d):
    if j == len(S): return True

    ak = a2 + d
    while True:
        s_ak = str(ak)
        if S[j:].startswith(s_ak):
            j  += len(s_ak)
            ak += d
            if j == len(S): return True
        elif s_ak.startswith(S[j:]):
            return True
        else:
            return False

def main():
    S = input()

    if S.startswith("0"):
        S = "1" + S

    # 初項 a1 を決める
    # i:第2項の開始位置
    i = 1
    for i in range(1, len(S)):
        if S[i] != "0": break
    if i < len(S) and S[i] == "0": i += 1
    a1 = int(S[:i])

    # 初項しかないなら公差1として終了
    if i == len(S):
        d = 1
        print(a1, d)
        return

    # 第2項 a2 を短い候補から順に試す
    # j:第3項の開始位置
    for j, a2 in seconds(S, i):
        if a2 <= a1: continue
        d = a2 - a1
        if is_ok(S, j, a2, d):
            print(a1, d)
            return

    # 全候補が失敗した場合、第2項が末項で、かつ末尾に数字を追加する必
    # 要がある
    s_a1 = str(a1)
    s_a2 = S[i:]
    if s_a1.startswith(s_a2):
        if a1 <= 9: # 11, 22, ..., 99
            d = 10*int(s_a2) - a1
        else: # 1010, 10010, 30003 など
            if s_a1 == s_a2:
                d = 10*int(s_a2) - a1
            else:
                d = 1
        print(a1, d)
    else:
        s_a2 += "0" * (len(s_a1)-len(s_a2))
        if a1 < int(s_a2):
            d = int(s_a2) - a1
        else:
            d = int(s_a2+"0") - a1
        print(a1, d)

if __name__ == "__main__": main()
