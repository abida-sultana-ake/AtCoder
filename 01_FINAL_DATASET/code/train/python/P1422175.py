# encoding:utf-8
def main():
	A, B = list(map(int, input().split()))
	ptrs = [A, B, A + B]
	res = [x % 3 for x in ptrs]
	if 0 in res:
		print("Possible")
	else:
		print("Impossible")

if __name__ == '__main__':
	main()