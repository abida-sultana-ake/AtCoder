N = int(input())
freq = {}
arr = map(int,input().split())
for i in arr:
    try:
        freq[i] += 1
    except KeyError:
        freq[i] = 1

to_multiply = []      
for i in sorted(freq.keys(),reverse=True):
    if freq[i] >= 4:
        to_multiply.append(i)
        to_multiply.append(i)
    elif freq[i] >= 2:
        to_multiply.append(i)
if len(to_multiply) >= 2:
    print(to_multiply[0] * to_multiply[1])
else:
    print("0")
