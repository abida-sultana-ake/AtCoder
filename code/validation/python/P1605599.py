N = int(input())
S = input()
array = [0]
cnt = 0
for w in S:
    if w == "I":
        cnt += 1
        array.append(cnt)
    else:
        cnt -= 1
        array.append(cnt)
print(max(array))
