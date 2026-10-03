S=input();
A,B,C,D =list(map(int,input().split()))
print('"'.join([S[:A],S[A:B],S[B:C],S[C:D],S[D:]]))
