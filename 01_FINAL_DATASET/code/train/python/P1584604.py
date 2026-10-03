from collections import Counter
input()
str= input()+"1234"
cnt = Counter(str).values()
print(max(cnt)-1,min(cnt)-1)