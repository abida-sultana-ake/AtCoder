A = [int(input())for _ in[None]*3]
for i in A:
    if max(A)==i:
        print(1)
    elif min(A)==i:
        print(3)
    else:
        print(2)