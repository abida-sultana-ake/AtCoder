A,B,C,D = map(int,input().split())
tmp_A = [i for i in range(A,B)]
tmp_B = [j for j in range(C,D)]
print(len(set(tmp_A)&set(tmp_B)))

