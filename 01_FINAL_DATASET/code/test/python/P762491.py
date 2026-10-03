a = input()
 
b = "WBWBWWBWBWBW"
b = b*10
 
res = "Do x Re x Mi Fa x So x La x Si"
res = res.split()
 
for i in range(12):
	if a == b[i:i+20]:
		print(res[i])