from itertools import permutations

def myfind(coin_self,all_coins):
    """
    目標コインとコイン全体を引数に取る。
    その目標コインが約数に取り得るコインが何枚あるか（S）を返す。
    """
    factor = -1
    for c in coins:
        if coin_self % c == 0: factor += 1
    return factor



N = int(input())
coins = []
for i in range(N): coins.append(int(input()))

accum = 0
for coin in coins:
    S = myfind(coin,coins)
    if S % 2 == 0: accum += (S+2) / (2*S+2)
    else: accum += 0.5

print(accum)