A, B, C, D, E, F = map(int, input().split())

ret_w = 1
ret_s = -1
for a in range(F // (100 * A) + 1):
    w_a = a * A * 100
    for b in range((F - w_a) // (100 * B) + 1):
        if a + b == 0:
            continue
        w_b = b * B * 100

        max_suger = min(F - w_a - w_b, (w_a + w_b) // 100 * E)
        for c in range(max_suger // C + 1):
            s_c = c * C
            for d in range((max_suger - s_c) // D + 1):
                s_d = d * D
                if ret_s / ret_w < (s_c + s_d) / (w_a + w_b + s_c + s_d):
                    ret_s = s_c + s_d
                    ret_w = ret_s + w_a + w_b

print(ret_w, ret_s)

