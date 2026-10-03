from sys import exit
from itertools import count

def read():
  return [int(x) for x in input().split()]

(N, K) = read()
D = input().split()

for i in count(N):
  if all(not d in str(i) for d in D):
    print(i); break
