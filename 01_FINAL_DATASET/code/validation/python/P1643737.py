# -*- coding: utf-8 -*-

# 入力の数値2つ
num_list = input().split()
num1 = int(num_list[0])
num2 = int(num_list[1])
# 大きい方を出力
if num1 > num2:
	print(num1)
elif num1 < num2:
	print(num2)
# num1 == num2 のことは考えなくていいはず(問題文より)
