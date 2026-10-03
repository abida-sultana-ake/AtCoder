A=int(input())
B=int(input())
C=int(input())

if A>B>C:
    print(1)
    print(2)
    print(3)
    
elif A>C>B:
    print(1)
    print(3)
    print(2)
    
elif C<A<B:
    print(2)
    print(1)
    print(3)
    
elif B<A<C:
    print(2)
    print(3)
    print(1)

elif A<C<B:
    print(3)
    print(1)
    print(2)

else:
    print(3)
    print(2)
    print(1)