cond = [int(n) for n in input().split(" ")]
data = []
for a in range(cond[0]):
    data.append(input())
data = sorted(data)
print("".join(data))