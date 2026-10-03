# coding:utf-8
s = input()
a, b, c, d = map(int, input().split(" "))
s = s[:a] + "\"" + s[a:]
s = s[:b+1] + "\"" + s[b+1:]
s = s[:c+2] + "\"" + s[c+2:]
s = s[:d+3] + "\"" + s[d+3:]

print(s)