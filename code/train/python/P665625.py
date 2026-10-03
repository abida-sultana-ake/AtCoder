# -*- coding: utf-8 -*-

S = input()
A, B, C, D = map(int, input().split())

ans = S[0:A] + '"' + S[A:B] + '"' + S[B:C] + '"' + S[C:D] + '"' + S[D:]

print(ans)
