import numpy as np
import math

n = int(input())
a = list(map(int,input().split()))

maenogoukei = a[0]
goukei = a[0]
kaisuu = 0

if goukei == 0:
	kaisuu += 1
	maenogoukei = -1 
	goukei = maenogoukei



for a_i in a[1:]:
	goukei += a_i
	if maenogoukei > 0 and goukei >= 0:
		kaisuu += goukei + 1
		goukei = -1
		maenogoukei = -1
	elif maenogoukei < 0 and goukei <= 0:
		kaisuu += -goukei + 1
		goukei = 1
		maenogoukei = 1
	else:
		maenogoukei += a_i




maenogoukei2 = a[0]
goukei2 = a[0]
kaisuu2 = 0

if goukei2 == 0:
	kaisuu2 += 1
	maenogoukei2 = 1 
	goukei2 = 1
else:
	kaisuu2 += abs(goukei2) + 1
	maenogoukei2 = - int(np.sign(a[0]))
	goukei2 = - int(np.sign(a[0]))


for a_i2 in a[1:]:
	goukei2 += a_i2
	if maenogoukei2 > 0 and goukei2 >= 0:
		kaisuu2 += goukei2 + 1
		goukei2 = -1
		maenogoukei2 = -1
	elif maenogoukei2 < 0 and goukei2 <= 0:
		kaisuu2 += -goukei2 + 1
		goukei2 = 1
		maenogoukei2 = 1
	else:
		maenogoukei2 += a_i2

print( min([kaisuu,kaisuu2]) )