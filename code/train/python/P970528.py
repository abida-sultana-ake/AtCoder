#!/usr/bin/env python3
# -*- coding: utf-8 -*-

S = input()


prev = ''
new_S = ''
for ch in S:
    if ch != prev:
        new_S += ch
    prev = ch
print(len(new_S)-1)


