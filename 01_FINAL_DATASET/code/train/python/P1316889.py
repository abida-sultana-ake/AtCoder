# -*- coding: utf-8 -*-

import os
import sys

class Main(object):

    def __init__(self):
        pass

    def some_method(self):
        o = input()
        e = input()
        ans = ''
        length = max(len(o), len(e))
        for i in range(length):
            if i < len(o):
                ans += o[i]
            if i < len(e):
                ans += e[i]
        print(ans)
                         
                

        return None

if __name__ == '__main__':
    m = Main()
    m.some_method()
