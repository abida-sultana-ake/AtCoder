R, B = map(int, input().split())
x, y = map(int, input().split())

# isWell
def isWell(k):
	e1 = (R-k) // (x-1)
	e2 = (B-k) // (y-1)

	return R >= k and B >= k and e1 + e2 >= k

# 条件を満たす最大の値を返す
def binarySearch(small, big):
	mid = (big + small) // 2
	if big == small or big == small + 1:
		if isWell(big):
			return big
		else:
			return small
	else:
		if isWell(mid):
			return binarySearch(mid, big)
		else:
			return binarySearch(small, mid)

print(binarySearch(0, min(R, B)))
