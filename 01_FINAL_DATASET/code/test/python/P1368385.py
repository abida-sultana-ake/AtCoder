a = int(input())
b = int(input())
n = int(input())

while not (n % a == 0 and n % b == 0):
    n += 1
else:
    print(n)