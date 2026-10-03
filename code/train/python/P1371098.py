# -*- coding: utf-8 -*-

import sys
import subprocess
import json
import time
import math
import re
import sqlite3

N = map(int, input().split())
a = list(map(int, input().split()))
a.sort()
print(a[-1] - a[0])
