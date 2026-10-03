import math
N = int(input())
p = sorted(sorted([tuple(map(int, input().split())) for _ in [0]*N], key=lambda x: x[1], reverse=True), key=lambda x: x[0])

class SegmentTree:
    __slots__ = ["elem_size", "tree_size", "tree", "default"]

    def __init__(self, a: list, default: int):
        real_size = len(a)
        self.elem_size = 1 << math.ceil(math.log2(real_size))
        self.tree_size = 2 * self.elem_size
        self.tree = [default] * self.elem_size + a + [default] * (self.elem_size - real_size)
        self.default = default
        self.init_tree()

    def init_tree(self) -> None:
        tree = self.tree
        for i in range(self.elem_size - 1, 0, -1):
            left, right = tree[i << 1], tree[(i << 1) + 1]
            # ===== change me =====
            tree[i] = left if left > right else right

    def get_value(self, x: int, y: int):
        l, r = x + self.elem_size, y + self.elem_size
        tree, result = self.tree, self.default
        while l < r:
            if l & 1:
                # ===== change me =====
                result = tree[l] if tree[l] > result else result
                l += 1
            if r & 1:
                r -= 1
                # ===== change me =====
                result = tree[r] if tree[r] > result else result
            l, r = l >> 1, r >> 1

        return result

    def set_value(self, i: int, value: int, op: str = "="):
        tree = self.tree
        k = self.elem_size + i
        if op == "=":
            tree[k] = value
        elif op == "+":
            tree[k] += value
        elif op == "?":
            # ===== change me =====
            tree[k] = value if value > tree[k] else tree[k]

        while k > 1:
            k >>= 1
            left, right = tree[k << 1], tree[(k << 1) + 1]
            # ===== change me =====
            tree[k] = left if left > right else right

dp = [0]*(10**5)
segtree = SegmentTree(dp, 0)
result = 0

for w, h in p:
    v = segtree.get_value(0, h)
    segtree.set_value(h, v+1, "?")

print(segtree.get_value(0, 10**5+1))