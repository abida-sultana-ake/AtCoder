s = input()
t = int(input())

x = s.count("L") - s.count("R")
y = s.count("U") - s.count("D")
q = s.count("?")

if t == 1:
    print(abs(x) + abs(y) + q)
else:
    print(max(abs(x) + abs(y) - q, len(s) % 2))
