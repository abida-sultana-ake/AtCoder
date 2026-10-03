#!/usr/bin/env python3
# -*- coding: utf-8 -*-



def main():
    N, L = map(int, input().split())

    perm = list(range(N))
    for _ in range(L):
        for i, c in enumerate(input()):
            if c == "-":
                k1 = i // 2
                k2 = i // 2 + 1
                perm[k1], perm[k2] = perm[k2], perm[k1]

    goal = input().index("o") // 2

    ans = perm[goal] + 1
    print(ans)

if __name__ == "__main__": main()
