# -*- coding: utf-8 -*-
N = int(input())
K = int(input())
X = int(input())
Y = int(input())
answer = 0
counter = 1
while counter <= N:
	if(counter <= K):
		answer += X
	else:
		answer += Y
	counter += 1
print (answer)