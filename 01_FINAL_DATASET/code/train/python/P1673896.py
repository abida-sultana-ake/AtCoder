#!/usr/bin/env python3
# -*- coding: utf-8 -*-



def main():
    S = input()

    ans = 0

    for term in S.split("+"):
        if "0" not in term:
            ans += 1

    print(ans)

if __name__ == "__main__": main()
