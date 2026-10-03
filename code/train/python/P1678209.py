# -*- coding: utf-8 -*-
# !/usr/bin/env python
# vim: set fileencoding=utf-8 :

"""
#
# Author:   Noname
# URL:      https://github.com/pettan0818
# License:  MIT License
# Created: 木 10/12 19:40:10 2017

# Usage
#
"""


def parse_exp(text: str):
    """
    >>> parse_exp("3*1+1*2")

    >>> parse_exp("2*0")

    >>> parse_exp("3*1*4+0+2*0+5*2+9*8*6+1+3")

    >>> parse_exp("3+1")
    """
    kakezan = text.split("+")
    tashizan = [i.split("*") for i in kakezan]

    return [[int(n) for n in m] for m in tashizan]

def count_change(target):
    """
    >>> count_change([[3, 1, 4], [0], [2, 0], [5, 2], [9, 8, 6], [1], [3]])
    """
    return sum([0 not in i for i in target])

if __name__ == '__main__':
    # import doctest
    # doctest.testmod()

    exp = input()

    print(count_change(parse_exp(exp)))
