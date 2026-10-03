N = int(input())
heights = [0 for i in range(N-1)]

tmp = 0
for i in range(N):
    a = int(input())
    if i == 0:
        tmp = a
        continue

    if a > tmp:
        heights[i-1] = 1
    else:
        heights[i-1] = -1
    tmp = a

l = [0 for i in range(N-1)]
up = True
m_len = 0
len = 0
for i in range(0,N-1):
    if heights[i] == 1 and up:
        len += 1
    elif heights[i] == -1:
        up = False
        len += 1
    elif heights[i] == 1 and not up:
        m_len = max(m_len,len)
        len = 1
        up = True
m_len = max(m_len, len)
print(m_len+1)