n = int(input())
a = [int(s) for s in input().split()]
result = -999999999999999
for i in range(n):
    target = a[i:]
    m_value = -9999999999999999999
    m_index = 9999999
    total = 0
    for j in range(n):
        if i==j:
            continue
        array = a[min(i,j):max(i,j)+1]
        point = sum([array[p] for p in range(len(array)) if p%2==1])

        if point > m_value:
            m_index = j
            m_value = point

    subtotal = sum([int(a[s]) for s in range(min(i, m_index),max(i, m_index)+1, 2)])
    result = max(result, subtotal)
print(result)