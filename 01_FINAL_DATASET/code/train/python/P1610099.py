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


def Restoring_Road_Network2():

    not_available = False
    for k in range(0, N):
        for i in range(0, N):
            if(k==i): continue
            for j in range(0, N):
                if((i==j) or (j==k)): continue
                if(A[i][k] + A[k][j] < A[i][j]):
                    not_availabel = True
                if(A[i][k] + A[k][j] == A[i][j]):
                    B[i][j] = 1
                    B[j][i] = 1

    try:
        LOCAL_FLAG
        print(B)
    except NameError:
        pass

    if(not_available):
        print(-1)
    else:
        total_dis = 0
        for i in range(0, N):
            for j in range(i, N):
                if(B[i][j] == 0):
                    total_dis += A[i][j]
        print(total_dis)

def Restoring_Road_Network3():

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

def AA():
    import numpy as np

    for i in range(N):
        A[i][i] = 10000000000

    result = 0
    for i in range(N-1):
        for j, d1 in enumerate(A[i][i+1:], start=i+1):
            d2 = np.min(A[i]+A[j])
            # print(A[i][i+1:])
            # print (i, j, d1, d2)
            if d1 >= d2:
                if d1 > d2:
                    print(-1)
                    exit()
            else:
                result += d1
    print(result)

Restoring_Road_Network3()