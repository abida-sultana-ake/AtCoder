N = int(input())
c = [i for i in range(1, 7)]
Nmod30 = N % 30
for i in range(Nmod30):
    k = i % 5
    c[k+1],c[k] = c[k],c[k + 1]
 
c_str = [str(x) for x in c]
print(''.join(c_str))