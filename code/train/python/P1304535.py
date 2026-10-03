s = input().split()
h = int(s[0])
w = int(s[1])

ain = ["" for i in range(h)]

for i in range(h):
    ain[i] = input()

aout = ["" for j in range(h+2)]

aout[0] = "#" * (w+2)

for i in range(h):
    aout[i+1] = "#" + ain[i] + "#"

aout[h+1] ="#" * (w+2)

for i in range(h+2):
    print(aout[i])
