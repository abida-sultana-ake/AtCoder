# -*- coding: utf-8 -*-
x, y = map(int, input().split(" "))
group_a = [1, 3, 5, 7, 8, 10, 12]
group_b = [4, 6, 9, 11]
group_c = [2]
x_group = ""
y_group = ""

if x in group_a:
    x_group = "a"
elif x in group_b:
    x_group = "b"
else:
    x_group = "c"

if y in group_a:
    y_group = "a"
elif y in group_b:
    y_group = "b"
else:
    y_group = "c"

if x_group == y_group:
    print("Yes")
else:
    print("No")
