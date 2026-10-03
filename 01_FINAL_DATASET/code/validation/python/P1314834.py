import numpy as np
x, y = map(int,input().split())
b = np.arange(x * y).reshape(x,y)
for i in range(x) :
  b[i] = list(map(int,input().split()))
be = 0;

if x == 1 :
  for i in range(y) :
    if b[0][i] == 0 :
      be = 1

if x == 2 :
  for i in range(y) :
    for j in range(y) :
      if b[0][i] ^ b[1][j] == 0 :
        be = 1

if x == 3 :
  for i in range(y) :
    for j in range(y) :
      for k in range(y) :
        if b[0][i] ^ b[1][j] ^ b[2][k] == 0 :
          be = 1

if x == 4 :
 for i in range(y) :
   for j in range(y) :
     for k in range(y) :
       for n in range(y) :
         if b[0][i] ^ b[1][j] ^ b[2][k] ^ b[3][n] == 0 :
           be = 1

if x == 5 :
  for i in range(y) :
    for j in range(y) :
      for k in range(y) :
        for n in range(y) :
          for m in range(y) :
            if b[0][i] ^ b[1][j] ^ b[2][k] ^ b[3][n] ^ b[4][m] == 0 :
              be = 1

if be == 1 :
  print ('Found')
else :
  print ('Nothing')