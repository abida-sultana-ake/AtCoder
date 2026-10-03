ss = input()
m = 0
for start in range(len(ss)//2):
    for end in range(start, len(ss) - 1):
        if len(ss[start:end]) > 0:
            if ss[start:end] == ss[end:2*end - start]:
                if (2*end - start) < len(ss):
                    m = max(m, 2*len(ss[start:end]))
print(m)