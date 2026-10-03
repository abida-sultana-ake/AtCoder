import numpy as np
import sys

def read_data():
    try:
        LOCAL_FLAG
        import codecs
        import os

        lines = []
        file_path = os.path.join(os.path.dirname(__file__), 'data.dat')
        with codecs.open(file_path, 'r', 'utf-8') as f:
            n_lines = int(f.readline())
            for i in range(n_lines):
                lines.append(f.readline().rstrip("\r\n"))

    except NameError:
        lines = []
        n_lines = int(input())
        for i in range(n_lines):
            lines.append(input())
    return lines

raw_data = read_data()
tarray = []
for each in raw_data:
    tarray.append(each.split())
A = np.array(tarray, dtype='int64')
N = A.shape[0]

def Restoring_Road_Network():

    import scipy.sparse.csgraph as graph

    MAX = [10000000000]*N  # should be > 2*10**9
    d = np.diag(MAX)
    C = A.copy()
    C += d
    total_dis = 0
    n_path = 0
    for i in range(N-1):
        for j in range(i+1, N):
            dis_two_node = np.min(C[i] + C[j])
            if dis_two_node > C[i,j]:
                total_dis += C[i,j]
                # print(i, j)
            elif dis_two_node < C[i,j]:
                print(-1)
                exit()

    print(total_dis)

Restoring_Road_Network()