s = input()
l = len(s)

if (s[0] == s[-1] and l % 2 == 0) or (s[0] != s[-1] and l % 2 != 0):
  print("First")
else:
  print("Second")