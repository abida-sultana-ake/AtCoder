#!/usr/bin/env python3
# -*- coding: utf-8 -*-


def judge(c1, c2):
    return c1.lower() == c2


def main():
    if judge(*input().split()):
        print("Yes")
    else:
        print("No")


if __name__ == '__main__':
    main()
