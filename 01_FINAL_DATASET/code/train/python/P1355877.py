s,c = map(int, input().split())
if c>=s*2:
    cleft = c-s*2
    print(s+cleft//4)
else:
    print(c//2)
