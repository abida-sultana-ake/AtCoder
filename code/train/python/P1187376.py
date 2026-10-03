N = int(input())
s = input()

b = [0 if si == 'o' else 1 for si in s]

for i in range(4):
    sw = [i & 1] + [(i >> 1) & 1] + [0] * (N - 2)

    for k in range(2, N):
        sw[k] = b[k - 1] ^ sw[k - 1] ^ sw[k - 2]

    if b[N - 1] != (sw[N - 2] ^ sw[N - 1] ^ sw[0]):
        continue
    if b[0] != (sw[N - 1] ^ sw[0] ^ sw[1]):
        continue

    ans = ['W' if si else 'S' for si in sw]
    print(''.join(ans))
    quit()

print(-1)