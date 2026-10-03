import itertools
print(sorted(set([sum(x)for x in itertools.combinations(list(map(int,input().split())),3)]))[-3])
