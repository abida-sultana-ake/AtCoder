from sys import stdin, stdout

n = int(stdin.read().strip())

result = str(int(n * (n + 1) / 2))

stdout.write(result)