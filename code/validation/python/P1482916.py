'''
Created on 2017/08/05

'''
# coding: UTF-8

N, L = map(int, input().split())

amd = []

for i in range(L + 1):
	amd.append(list(input()))

current_pos = 0

for s in amd[L]:
	if( s == 'o' ):
		amd.pop()
		break
	else:
		current_pos += 1

for line in amd[::-1]:
	line.append(' ')
	if( current_pos > 0 ):
		if( ( line[current_pos - 1] ) == '-' ):
			current_pos -= 2
			continue
	if( current_pos < len(line) ):
		if( ( line[current_pos + 1] ) == '-' ):
			current_pos += 2

print(int((current_pos/2) + 1))