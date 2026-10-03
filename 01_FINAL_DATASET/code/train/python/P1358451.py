N = input()
digit = int( int(N)/1000 ) #四桁目
Digit = str( digit )
ND = Digit*4 
if N == ND:
    print('SAME')
else:
    print('DIFFERENT')