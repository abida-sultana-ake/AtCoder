x = int(input())
ans = (x//11)*2
x = x%11
if x>0 and x<=6:
	ans = ans+1
elif x>6:
	ans = ans+2
print(ans)
