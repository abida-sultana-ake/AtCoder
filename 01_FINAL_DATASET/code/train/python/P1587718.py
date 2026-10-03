# coding: utf-8
# Here your code !
a,b,c,d = map(int, input().split())
print(max(min(b,d)-max(a,c),0))
