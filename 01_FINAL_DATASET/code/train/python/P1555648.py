# -*- coding:utf-8 -*-
h, m = map(int, input().split())
if h <= 18:
    if h == 18 and m != 0:
        hour = 18+(24-h)
    else:
        hour = 18-h
else:
    hour = 18+(24-h)
if m:
    minute = 60-m
    hour -= 1
else:
    minute = m

print(hour*60+minute)