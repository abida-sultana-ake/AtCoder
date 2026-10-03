S = input()

s_ind = 0
e_ind = 0


for i, s in enumerate(S):
    if s == "A":
        s_ind = i
        break
        
for i in range(len(S)):
    if S[-(i+1)] == "Z":
        e_ind = len(S)-(i+1)
        break
        
print(e_ind - s_ind + 1)