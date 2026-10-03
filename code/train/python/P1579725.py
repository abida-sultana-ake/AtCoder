N = int(input())
writing = set()
for n in range(N):
    A = int(input())
    if A in writing:
        writing.remove(A)
    else:
        writing.add(A)
print(len(writing))