w = input()
c = [chr(i) for i in range(ord("a"), ord("z")+1)]
for i in c:
  if w.count(i) % 2 == 1:
    print("No")
    exit()
print("Yes")