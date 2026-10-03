n = input()

lst = list(n)
lst.sort()
if lst[0] == lst[3]:
    print("SAME")
else:
    print("DIFFERENT")