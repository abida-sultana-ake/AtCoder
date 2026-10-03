str = str(raw_input())
a, b, c, d = map(int, raw_input().split())

s1 = str[0:a]
s2 = str[a:b]
s3 = str[b:c]
s4 = str[c:d]
s5 = str[d:]

print(s1 + '"' + s2 + '"' + s3 + '"' + s4 + '"' + s5)
