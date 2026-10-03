"""
AtCoder Begginer Contest
"""

# get n, X
n, X = map(int, input().split())

costs = input().split()

# 
tmpBit = 1
total = 0


for i in range(0, n):

    # calc total cost
    bit = (X & tmpBit)
    if bit != 0:
        total += int(costs[i])

    # tmpBit slide left
    tmpBit *= 2

# output
print(total)
