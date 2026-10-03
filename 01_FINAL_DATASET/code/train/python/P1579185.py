N = int(input())
s = set()
for i in range(N):
    A = input()
    if A in s:
        s.remove(A)
    else:
        s.add(A)
print(len(s))
