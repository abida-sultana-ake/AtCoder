# -*- coding: utf-8 -*-

import sys
import os

# assume X is larger
X, Y = map(int, input().split())
if X < Y:
    X, Y = Y, X

diff = X - Y
if diff > 1:
    print('Alice')
else:
    print('Brown')