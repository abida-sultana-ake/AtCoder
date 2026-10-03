#!/usr/bin/env python3
# -*- coding: utf-8 -*-



def main():
    H, W = map(int, input().split())

    print("#" * (W+2))
    for _ in range(H):
        s = input()
        print("#", end="")
        print(s, end="")
        print("#")
    print("#" * (W+2))

if __name__ == "__main__": main()
