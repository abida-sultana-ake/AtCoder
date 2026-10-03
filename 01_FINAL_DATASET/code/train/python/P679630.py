#!/usr/bin/python3
S = input()
A, B, C, D = map(int, input().split())
S = S[:D] + '"' + S[D:]
S = S[:C] + '"' + S[C:]
S = S[:B] + '"' + S[B:]
S = S[:A] + '"' + S[A:]
print(S)