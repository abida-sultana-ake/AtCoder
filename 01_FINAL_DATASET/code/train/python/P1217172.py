# -*- coding: utf-8 -*-

import sys
import os


X = int(input())

for t in range(1, 10**10):
    # t秒後にたどり着けるか
    # t秒経ったと言うことは、1 + 2 + ... + tだけ進めるということ
    S = t * (t + 1) / 2
    if S >= X:
        print(t)
        break
