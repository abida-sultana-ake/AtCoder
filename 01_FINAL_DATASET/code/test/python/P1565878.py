# coding: utf-8

N = int(input())
o = [0 for i in range(24 * 60 // 5 + 1)]
c = 0
s = 0
e = 0
f = False

for i in range(N):
    ipt_st, ipt_en = map(int, input().split('-'))
    start = ipt_st // 100 * 60 + ipt_st % 100 - ipt_st % 5
    end = ipt_en // 100 * 60 + ipt_en % 100 + (5 - ipt_en % 5) % 5
    o[start // 5] += 1
    o[end // 5] -= 1

for i in range(len(o)):
    c += o[i]
    if c > 0 and not f:
        s = i * 5 // 60 * 100 + i * 5 % 60
        f = True
    elif c == 0 and f:
        e = i * 5 // 60 * 100 + i * 5 % 60
        f = False
        print("{:04d}-{:04d}".format(s, e))
