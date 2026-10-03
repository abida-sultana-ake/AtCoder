#!/usr/bin/env python3
# -*- coding: utf-8 -*-

def main():
    tsrc = "".join(input().split())
    tdst = "0123456789"
    trans = str.maketrans(tsrc, tdst)

    N = int(input())
    A = [input() for _ in range(N)]

    A.sort(key=lambda s: int(s.translate(trans)))

    for s in A:
        print(s)

if __name__ == "__main__": main()
