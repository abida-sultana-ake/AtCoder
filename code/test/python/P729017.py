#!/usr/bin/env python
# -*- coding: utf-8 -*-


def main():
    H, W = map(int, raw_input().split())

    result = 0

    result += (W-1) * H
    result += (H-1) * W

    print(result)
    return 0


if __name__ == '__main__':
    main()
