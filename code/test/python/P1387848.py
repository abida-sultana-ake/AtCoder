N = int( input() )
a = []

for i in range(N):
    a.append( int( input() ) )
b = sorted(a)    
print(b[0])