table = input().split()
A,B,C = int(table[0]),int(table[1]),int(table[2])
if A <= C and C<= B:
    print('Yes')
else:
    print('No')