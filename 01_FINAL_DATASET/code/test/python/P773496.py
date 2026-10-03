#!/usr/bin/python3
 
n, x = list(map(int, input().split()))
 
print(min(x-1,n-x))