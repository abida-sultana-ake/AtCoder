#!/usr/bin/env python3

NO_SOL = (-1, -1)


# 所与の文字列の部分文字列であって、アンバランスなものを1つ探す
# 対象とするのは、"AA"および"ABA"のみ
# 結果のインデックスは0始まりである
def search_unbalanced_substr(s):
    n = len(s)
    # "AA"を探す
    for i in range(n - 1):
        if s[i] == s[i + 1]:
            return i, i + 1
    # "ABA"を探す
    for i in range(n - 2):
        if s[i] == s[i + 2]:
            return i, i + 2
    # 見つからなければ
    return NO_SOL


def main():
    ans = search_unbalanced_substr(input())
    if ans == NO_SOL:
        print(*ans)
    else:
        print(*(i + 1 for i in ans))


if __name__ == '__main__':
    main()
