#!/usr/bin/env python3
# -*- coding: utf-8 -*-

import array
from bisect import *
from collections import *
import fractions
import heapq 
from itertools import *
import math
import re
import string

N = int(input())
As = list(map(int, input().split()))
c = Counter(As)

ans = 0
for i in range(100000):
    ans = max(ans, c[i-1] + c[i] + c[i+1])
print(ans)

