from functools import*
@lru_cache(maxsize=None)
def d(n):x=n//2;return n+1 if n<2 else d(x)+d(~-x)+d(n+~x)
print(d(int(input()))%(10**9+7))