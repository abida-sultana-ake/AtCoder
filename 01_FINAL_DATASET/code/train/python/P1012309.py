s=input();l=len(s)
print("Second"*((s[0]!=s[-1])^l&1or s in s[0:1]*l)or"First")