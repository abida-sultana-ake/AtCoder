#!/usr/bin/env python3
 
N = int(input())
a = list(map(int, input().split()))
 
print(max(a) - min(a))