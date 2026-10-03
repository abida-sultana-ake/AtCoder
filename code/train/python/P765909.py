A, B = map(int, input().split())
q, r = divmod(B, A)
print(q + (r != 0))