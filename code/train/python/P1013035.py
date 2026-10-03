#coding: UTF-8

import math


if __name__ == "__main__":
	data = list(map(int,input().split()))
	a = data[0]
	b = data[1]
	x = data[2]
	if a%x == 0:
		print((b-a)//x+1)
	else:
		if x > b:
			print("0")
		else: 
			if x < a:
				print((data[1]-(a+(x-a%x)))//data[2]+1)
			else:
				print((data[1]-data[2])//data[2]+1)