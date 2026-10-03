N = int(input())
src = [int(input()) for i in range(N)]

longest = seq = 1
fi_seq = -1
for i in range(N-1):
    if src[i] == src[i+1]:
        seq += 1
    else:
        if fi_seq < 0: fi_seq = seq
        longest = max(longest, seq)
        seq = 1
if src[0] == src[-1] and fi_seq > 0:
    seq += fi_seq
longest = max(longest, seq)

if longest == N:
    print(-1)
else:
    print((longest+1) // 2)
