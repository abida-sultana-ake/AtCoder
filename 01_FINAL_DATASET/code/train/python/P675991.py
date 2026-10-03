#coding:utf-8

w, h = map(int, raw_input(). split())
#4:3の場合
x = 4 * h / 3

if x == w:
    print("4:3")
else:
    print("16:9")
