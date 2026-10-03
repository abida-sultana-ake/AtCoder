import itertools

n = int(input())

pro = list(itertools.product("abc", repeat=n))
for i in pro:
    print("".join(i))
