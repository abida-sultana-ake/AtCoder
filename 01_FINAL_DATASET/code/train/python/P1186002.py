from math import sqrt

# C-Digits in Multiplication
# 問題URl:http://abc057.contest.atcoder.jp/tasks/abc057_c

N = int(input())
F = 999;
for i in range(1,int(sqrt(N))+1):
    
    if N%i == 0: #余りが0 = iは整数なので整数同士の割り算ということ(余りを求める際には少数まで商を求めない）
        F =  min(F , max( len(str(i)) , len(str(N//i)) ) )
print(F)
        