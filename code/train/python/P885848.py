import itertools
nums = input()
index = range(1, len(nums))
def resolve(i):
    t = list(nums)
    for j in reversed(i): t.insert(j, "+")
    return eval("".join(t))

print(sum([resolve(i) for i in itertools.chain(*[itertools.combinations(index, x) for x in range(len(index) + 1)])]))
