(a, b) = map(int, raw_input().split())
(c, d) = map(int, raw_input().split())

print ("YES" if a == c or a == d or b == c or b == d else "NO")
