n = int(input().strip())
a = [int(x) for x in input().strip().split()]
num = len(list(set(a)))
print(num - (n - num) % 2)