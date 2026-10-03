from sys import stdout
n = int(input())
maxlen = maxnode = 0
for i in range(2,n+1):
    print("? {0} {1}".format(1, i))
    stdout.flush()
    dist = int(input())
    if maxlen < dist:
        maxlen = dist
        maxnode = i
for i in range(1,n+1):
    if i==maxnode : continue
    print("? {0} {1}".format(maxnode, i))
    stdout.flush()
    dist = int(input())
    if maxlen < dist: maxlen = dist
print("!",maxlen)