n = int( input() )

for j in range(1,n+1):
    a = int(n/j)
    b = n%j
    
    if j == 1:
        n_ans = abs(a-j) + b
    else:
        n_ans = min( n_ans,abs(a-j)+b )
 
print(n_ans)