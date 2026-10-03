s = input()
k = int(input())
S = set()
for i in range(len(s)-k+1):
 S.add(s[i:i+k])
print(len(S))