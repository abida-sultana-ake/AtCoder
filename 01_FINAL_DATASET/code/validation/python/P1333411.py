N, M = map(int, input().split())
hayai_usagi = [0]*N
for i in range(M):
    x, y = map(int, input().split())
    hayai_usagi[y-1] += 1 << (x-1)

bit_max = 1 << N
dp = [0]*bit_max
dp[0] = 1

for bitset in range(bit_max):
    for usa_num in range(N):
        usa_bit = 1 << usa_num
        others = bitset - usa_bit
        if bitset & usa_bit and\
                hayai_usagi[usa_num] & others == hayai_usagi[usa_num]:
            dp[bitset] += dp[bitset - usa_bit]

print(dp[bit_max-1])