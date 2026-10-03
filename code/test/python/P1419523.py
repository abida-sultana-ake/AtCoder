import math
M = int(input())
a = 0
b = 0
c = 0
if M < 60:
    c = M
elif M >= 60 and M < 3600:
    d = M / 60
    b = math.floor(d)
    c = M % 60
elif M >= 3600:
    d = M / 3600
    e = M / 60 - 60 * math.floor(d)
    f = M % 60
    a = math.floor(d)
    b = math.floor(e)
    c = f
print("{0:02d}".format(a) + ":" + "{0:02d}".format(b) + ":" + "{0:02d}".format(c))
