str = input()
k = int(input())
s = set()
for i in range(len(str)-k+1):
    s.add(str[i:i+k])
print(len(s))