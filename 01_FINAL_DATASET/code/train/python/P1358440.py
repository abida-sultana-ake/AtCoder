A, D = [int(i) for i in input().split()]

if ( A+1 )*D >= ( D+1 )*A:
    print( ( A+1 )*D )
elif ( D+1 )*A >= ( A+1 )*D:
    print( ( D+1 )*A )
else:
    print( ( A+1 )*D )