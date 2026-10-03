# -*- coding: utf-8 -*-

import sys
import os
import math

A, B, C = map(int, input().split())

if A <= C <= B:
    print('Yes')
else:
    print('No')