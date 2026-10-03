Name = input()
N = len(Name)
flag = True
for i in range(N // 2):
    if Name[i] != Name[N-1-i]:
        flag = False
if flag:
    print("YES")
else:
    print("NO")