s = input().strip()
t = input().strip()

csa = [0]
csb = [0]
for ch in s:
  if ch == "A":
    csa.append(csa[-1]+1)
    csb.append(csb[-1])
  else:  
    csa.append(csa[-1])
    csb.append(csb[-1]+1)
cta = [0]
ctb = [0]
for ch in t:
  if ch == "A":
    cta.append(cta[-1]+1)
    ctb.append(ctb[-1])
  else:  
    cta.append(cta[-1])
    ctb.append(ctb[-1]+1)
    
Q = int(input())
for q in range(Q):
  a, b, c, d = map(int, input().split())
  sa = csa[b] - csa[a-1]
  sb = csb[b] - csb[a-1]
  ta = cta[d] - cta[c-1]
  tb = ctb[d] - ctb[c-1]
  if (sa - sb + tb - ta) % 3:
    print("NO")
  else:  
    print("YES")
