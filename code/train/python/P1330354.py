n, a, b = [int(i) for i in input().split()]
hs = [None]*n
kill_b = [None]*n
for i in range(n):
    hs[i] = int(input())
max_hp = max(hs)
ret = 0
ab = a - b
right = max_hp // b
if((max_hp % b) != 0):
    right += 1
left = 1
while right != left:
    middle = (right + left) // 2
    # print([left, right, middle])
    all_a = 0
    for x in hs:
        nokori = x - (b * middle)
        if(nokori > 0):
            num_a = nokori // ab
            if(x > num_a * a + (middle - num_a) * b):
                num_a += 1
            all_a += num_a
    if(all_a <= middle):
        right = middle
    else:
        left = middle + 1
ret = right
print(ret)
