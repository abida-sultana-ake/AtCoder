N, A, B = list(map(int, input().split(" ")))
X_list = list(map(int, input().split(" ")))

val = 0

for X1, X2 in zip(X_list[:-1], X_list[1:]):
    A_val = A*(X2-X1) 
    if A_val > B:
        val += B
    else:
        val += A_val
print (val)