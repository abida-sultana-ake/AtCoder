# encoding:utf-8
import copy

def main():
	n = int(input())
	a = list(map(int, input().split()))

	print(calc(a))
	
def calc(temp):
	i = 0
	# print(temp)
	n = len(temp)
	while max(temp) >= n:
		sum_count = sum([x // n for x in temp])
		i += sum_count
		temp = [x - (x // n) * n + sum_count - (x // n) for x in temp]
		#print(temp)

	return i

if __name__ == '__main__':
	main()