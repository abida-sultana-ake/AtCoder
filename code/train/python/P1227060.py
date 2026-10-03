import sys
import numpy as np
import string

N = int(input())
S = [input() for i in range(N)]

dict = string.ascii_lowercase#abc...xyz

data_list = np.zeros((N,26))

for i in range(0,N):
	list = []
	for j in range(0,26):
		list.append(S[i].count(str(dict[j])))
	data_list[i] = np.array(list)
data_min = data_list.min(axis = 0)

a = np.nonzero(data_min)
size = np.nonzero(data_min)[0].size
b = a[0]
kotae = ""
for i in range(size):
	Moji = dict[b[i]]*int(data_min[b[i]])
	kotae = kotae + Moji
	pass
print(kotae)

