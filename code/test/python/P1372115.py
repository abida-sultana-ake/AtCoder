H, W, N = map(int, input().split())
current_line = 0
ans = [0 for i in range(10)]
kuro = dict()

for i in range(N):
    a, b = map(int, input().split())
    for y in range(max(a-2, 1), min(a+1, H-1)):
        for x in range(max(b-2, 1), min(b+1, W-1)):
            p = (y, x)
            if p in kuro:
                kuro[p] += 1
            else:
                kuro[p] = 1

for n in kuro.values():
    ans[n] += 1
ans[0] = (H-2)*(W-2)-len(kuro)
print("\n".join([str(n) for n in ans]))