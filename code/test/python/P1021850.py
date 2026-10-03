#!/usr/bin/env python
# coding: utf-8

import sys

def main():
    s = raw_input()
    num_g = sum(1 for c in s if c == 'g')
    num_p = sum(1 for c in s if c == 'p')
    print (num_g-num_p)/2

if __name__ == '__main__':
    main()
