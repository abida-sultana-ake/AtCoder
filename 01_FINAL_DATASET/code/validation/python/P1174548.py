# -*- coding:utf-8 -*-
n = int(input())
words = input().split()
output = ""

table = [["z","r"],["b","c"],["d","w"],["t","j"],["f","q"],["l","v"],["s","x"],["p","m"],["h","k"],["n","g"]]
for word in words:
    o = ""
    for s in word:
        for i,t in enumerate(table):
            if s.lower() in t:
                o += str(i)
                break
    if o:
        output += o + " "
output = output.rstrip()
print(output)
