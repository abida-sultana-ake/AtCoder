def dict_count(dict, key):
	if key in dict:
		dict[key] = dict[key]+1
	else:
		dict[key] = 1
	return dict

N = int(input())
divs = {}
primes = [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31]
for n in range(2, N+1):
	for p in primes:
		while n%p==0:
			divs = dict_count(divs, p)
			n = n//p
		if p*p>n:
			break
	if n!=1:
		dict_count(divs, n)
result = 1
base = 10**9+7
for c in divs.values():
	result = (result*(c+1))%base
print(result)
