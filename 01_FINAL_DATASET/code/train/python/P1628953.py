#!/usr/bin/env python3
# -*- coding: utf-8 -*-



def main():
    N, M = map(int, input().split())

    playing = 0
    disks = list(range(1, N+1))

    for _ in range(M):
        d = int(input())
        if(d == playing): continue
        idx = disks.index(d)
        disks[idx] = playing
        playing = d

    for d in disks:
        print(d)

if __name__ == "__main__": main()
