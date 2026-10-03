w_list = list(str(input()))
w_list.sort()
l = len(w_list)

if l == 1:
    print("No")
    exit()

for i,j in zip(range(0, l, 2) ,range(1, l, 2)):
    if w_list[i] != w_list[j]:
        print("No")
        break
else:
    print("Yes")
