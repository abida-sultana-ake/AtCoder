#!/usr/bin/env python3
# -*- coding: utf-8 -*-
def add_range(new_range):
    new_left, new_right, new_value = new_range
    global ranges
    index = 0
    new_ranges = [new_range]
    while index < len(ranges):
        range_ = ranges[index]
        left, right, value = range_
        if right <= new_left or new_right <= left:
            index += 1
            continue
        del ranges[index]
        if new_left <= left and right <= new_right:
            continue
        if left < new_left and new_right < right:
            new_ranges.append((left, new_left, value))
            new_ranges.append((new_right, right, value))
            continue
        if left < new_left:
            new_ranges.append((left, new_left, value))
        else:
            new_ranges.append((new_right, right, value))
    ranges.extend(new_ranges)
ranges = []
length, num_queries = map(int, input().split())
ranges.append((0, length, 0))
for _ in range(num_queries):
    left, right, value = map(int, input().split())
    left -= 1
    add_range((left, right, value))
ranges.sort()
for range_ in ranges:
    left, right, value = range_
    for _ in range(left, right):
        print(value)