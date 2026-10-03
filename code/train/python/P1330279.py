N,A,B = map(int, input().split())

H = [int(input()) for i in range(N)]

d = A-B

temp = max(H)
low = temp//A - 1
high = temp//B+1

while low + 1 < high:
  mid = (low+high)//2
  offset = mid*B
  cnt = -sum((offset-h)//d for h in H if h > offset)
  if cnt > mid:
    low = mid
  else:
    high = mid

print(high)