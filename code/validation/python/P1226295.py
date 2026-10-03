N = input()
flag = 0
if N.find('3') != -1:
    flag = 1
N = int(N)
if (N%3) == 0:
    flag = 1
if flag == 1:
    print ('YES')
else:
    print ('NO')
