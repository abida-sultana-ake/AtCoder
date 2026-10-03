def get_2div(v):
    while v % 2 == 0:
        v //= 2
    return v


N = input()
print(len(set(map(lambda x: get_2div(int(x)), input().split()))))
