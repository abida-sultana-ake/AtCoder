s = input()
k = int(input())
sub_s = set()
for i in range(len(s)):
    if len(s[i:i+k]) == k:
        sub_s.add(s[i:i+k])
print(len(sub_s))
