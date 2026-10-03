def Main():
  n = int(input())
  A = list(map(int, input().split()))
  s = set(A)

  if len(s)%2 == 0:
    print(len(s) - 1)
  else:
    print(len(s))

if __name__ == '__main__':
  Main()