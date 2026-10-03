N,VA,VB,L = map(int, raw_input().split())

dist = L * 1.0
for i in range(N):
  t = dist / VA
  dist = t * VB
print ('%.10f' % dist)