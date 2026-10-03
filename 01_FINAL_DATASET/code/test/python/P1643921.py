# -*- coding: utf-8 -*-

# 入力の文字列
str1 = input()
# aiueoの削除
str1 = str1.replace("a", "")
str1 = str1.replace("i", "")
str1 = str1.replace("u", "")
str1 = str1.replace("e", "")
str1 = str1.replace("o", "")
# 出力
print(str1)
