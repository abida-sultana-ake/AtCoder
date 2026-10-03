a = raw_input().strip()
ans = ''
counter = 1
for x in a:
	if counter % 2 == 1:
		ans += x
	counter += 1
print(ans)