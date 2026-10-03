N, M = map(int, input().split())
v = [i for i in range(N)]
is_tree = [1 for i in range(N)]

def get_root(n):
    if n == v[n]:
        return n
    else:
        v[n] = get_root(v[n])
        return v[n]

def union(a, b):
    a, b = get_root(a), get_root(b)
    if a!=b:
        v[b] = a
        if not all((is_tree[a], is_tree[b])):
            is_tree[a], is_tree[b] = 0, 0
    else:
        is_tree[a] = 0

def check_union(a, b):
    return True if get_root(a) == get_root(b) else False

for i in range(M):
    a, b = map(int, input().split())
    union(a-1, b-1)

s = set({get_root(n) for n in set(v)})
print(sum([is_tree[n] for n in s]))