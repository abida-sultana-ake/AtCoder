[a, b, c, k] = [int(num) for num in input().split()];
[s, t] = [int(num) for num in input().split()];
if s + t < k:
	print(a * s + b * t);
else:
	print((a - c) * s + (b - c) * t);