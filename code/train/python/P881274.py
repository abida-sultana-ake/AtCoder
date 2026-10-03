from itertools import product

S = tuple(input())
N = len(S)
res = 0
for ops in product(["+", ""], repeat=N-1):
    exp = "".join([n + op for n, op in zip(S, ops+("",))]).strip("+")
    res += eval(exp)
print(res)
