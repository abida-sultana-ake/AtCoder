n = int(input())
 
import itertools
l = [0 , 1, 2]
for element in itertools.product(l, repeat = n):
    s = ""
    for i in range(len(element)) : 
        s += chr(97 + element[i])
    print(s)
