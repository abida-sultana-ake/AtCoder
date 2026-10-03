#!/usr/bin/env python3
# -*- coding: utf-8 -*-



def main():
    N = int(input())

    total = 0
    for _ in range(N):
        a, b = map(int, input().split())
        total += a * b

    total += total // 20

    print(total)

if __name__ == "__main__": main()
