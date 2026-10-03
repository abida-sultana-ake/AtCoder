S = input()

base = "WBWBWBW"

i = S.index(base)

scale = ["Do", "Re", "Mi", "Fa", "So", "La", "Si"]

cnt = 0
for c in S[0:i]:
    if c == 'W':
        cnt += 1
    
print(scale[3 - cnt])
