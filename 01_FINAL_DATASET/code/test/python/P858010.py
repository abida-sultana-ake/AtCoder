import string
W = input()
for s in string.ascii_lowercase:
    cnt = W.count(s)
    if cnt % 2 != 0:
        print("No")
        exit()
print("Yes")
