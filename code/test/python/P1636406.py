#!/usr/bin/env python3
# -*- coding: utf-8 -*-

def main():
    m, n, N = map(int, input().split())

    product  = N
    material = 0
    ans = 0
    while True:
        if 0:
            print(product, material)
        ans += product
        material += product
        q        = material // m
        material = material %  m
        if q == 0: break
        product = n * q

    print(ans)

if __name__ == "__main__": main()
