import fileinput
m = 0
for line in fileinput.input():
    l = line.split()
    n = int(l[0]) * int(l[1]) / 10
    m += n
print(int(m))