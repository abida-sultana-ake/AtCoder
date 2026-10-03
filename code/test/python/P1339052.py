n = int(input())
d = {}
for i in range(n):
    name = input()
    d [name] = d.get(name,0)+1

print(max(d.items(), key=lambda x:x[1])[0])
