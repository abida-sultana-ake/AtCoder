A,B,C,D = list(map(int, input().split()))
start = max(A,C)
end = min(B, D)

if start > end:
    print(0)
else:
    print(end-start)
