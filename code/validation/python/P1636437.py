#!/usr/bin/env python3
# -*- coding: utf-8 -*-

MAP = {
    "b" : "1",
    "c" : "1",
    "d" : "2",
    "w" : "2",
    "t" : "3",
    "j" : "3",
    "f" : "4",
    "q" : "4",
    "l" : "5",
    "v" : "5",
    "s" : "6",
    "x" : "6",
    "p" : "7",
    "m" : "7",
    "h" : "8",
    "k" : "8",
    "n" : "9",
    "g" : "9",
    "z" : "0",
    "r" : "0",
}

def word_conv(w_from):
    w_to = ""
    for c_from in w_from:
        w_to += MAP.get(c_from, "")
    return w_to

def main():
    N = int(input())
    S = input().lower()

    result = []
    for w_from in S.split():
        w_to = word_conv(w_from)
        if w_to: result.append(w_to)

    print(" ".join(result))

if __name__ == "__main__": main()
