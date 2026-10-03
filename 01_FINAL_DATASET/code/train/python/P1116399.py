l = input().split()
n = int(l[0])
m = int(l[1])
a = 0

if n > (m // 2):
    print( m//2 )
else:
    print(n+(m-2*n) // 4)