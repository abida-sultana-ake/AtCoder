I = int(input())

amari = I%11
shou  = I//11
if amari == 0:
  print( shou*2 )
elif amari <= 6:
  print( shou*2 + 1 )
else:
  print( shou*2 + 2)
