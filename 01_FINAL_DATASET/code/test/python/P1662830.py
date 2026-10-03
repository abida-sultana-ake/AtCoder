import math
from sys import stdin, stdout
def readLine_int_list():return list(map(int, stdin.readline().split()))
def readLine_int_list_reverse(): return list(map(int, stdin.readline().split())).reverse()
def readAll_int(): return list(map(int, stdin))
def readLine_str_list():return list(map(int, stdin.readline().split()))
def readAll_str(): return list(map(int, stdin))
def g_twoD_list(p,q): return [[0 for i in range(p)] for j in range(q)]

def gcd(a, b):
	while b:
		a, b = b, a % b
	return a
	
def lcm(a, b):
	return a * b // gcd (a, b)
	
def main():
    a,b,n = readAll_int()
    l = lcm(a,b)
    print(l * math.ceil(n/l))
    
if __name__ == "__main__":
    main()
