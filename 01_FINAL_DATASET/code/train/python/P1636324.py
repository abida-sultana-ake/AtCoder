A, B, C, D, E, F = map(int, input().split())
 
x = set()
y = set()
 
for i in range(F // (100 * A) + 1):
    for j in range((F - 100 * A * i) // (100 * B) + 1):
        if i + j == 0:
            continue
        x.add(A * i * 100 + B * j * 100)
 
for i in range(F // C + 1):
    for j in range((F - C * i) // D + 1):
        y.add(C * i + D * j)
 
ret_w = 1
ret_s = -1
 
for w in x:
    for s in y:
        if w + s <= F and w * E / 100 >= s and s / (w + s) >= ret_s / ret_w:
            ret_s = s
            ret_w = w + s
 
print(ret_w, ret_s)