input()
print(sum([a for i, a in enumerate(sorted(map(int, input().split()), reverse=True)) if i % 2 == 0]))
