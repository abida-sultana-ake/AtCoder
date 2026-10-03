length = eval(input())
seq = list(map(int, input().split()))

counter = 1
sublen = []
ans = 0


for i in range(1, length):
    if seq[i - 1] >= seq[i]:
        # sublen.append(counter)
        ans += counter * (counter + 1) // 2
        counter = 0
    counter += 1
else:
    ans += counter * (counter + 1) // 2
    # sublen.append(counter)

print(ans)
# print(sum([x * (x + 1) // 2 for x in sublen]))
