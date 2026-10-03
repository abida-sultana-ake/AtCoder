#!/usr/bin/env python3
# -*- coding: utf-8 -*-



def main():
    N = int(input())
    A = [input() for _ in range(N)]

    A.sort(key=lambda s: s[::-1])

    for s in A:
        print(s)

if __name__ == "__main__": main()
