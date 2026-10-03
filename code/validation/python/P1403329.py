# coding: utf-8

nums=[int(x) for x in input().split()]
N,K = nums[0],nums[1]

T = []
for i in range(N):
	t = [int(x) for x in input().split()]
	T.append(t)

def dfs(numQ,value):
	"""
	今の質問数、値から今どこにいるかを格納
	質問がもうなければ０になっているかを調べる
	dfs関数の中からもう一度dfsをもう一度呼び出す
	探索した結果、0になる組み合わせがなければfalse
	"""
	if(numQ == N):return value == 0
	for i in range(K):
		if (dfs(numQ+1,value ^ T[numQ][i])): return True
	return False

if dfs(0,0): print("Found")
else: print("Nothing")