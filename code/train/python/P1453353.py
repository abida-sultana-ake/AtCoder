st = input()
arr = []
temp = ""

for c in st:
    if (len(temp) == 0):
        temp = c;
    else:
        if (temp[0] == c):
            temp += c
        else:
            arr.append(temp)
            temp = c

if (len(temp) != 0):
    arr.append(temp)

result = ""
for s in arr:
    count = len(s)
    t = s[0] + str(count)
    result += t
    
print(result)