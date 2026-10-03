#!/usr/bin/env python3
# -*- coding: utf-8 -*-



def main():
    N, L = map(int, input().split())
    SS = [input() for _ in range(N)]

    SS.sort()
    print("".join(SS))

if __name__ == "__main__": main()
