
s = [int(input()) for _  in range(3)]

s_s = sorted(s, reverse=True)

for i in s:
    print(s_s.index(i) + 1)