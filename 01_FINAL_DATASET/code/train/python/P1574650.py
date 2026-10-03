n = int(input())
a = input().split()

print(' '.join(a[-1::-2] + a[(n % 2)::2]))
