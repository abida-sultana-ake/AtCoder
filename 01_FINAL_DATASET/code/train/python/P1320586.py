h, w = list(map(int, input().split()))

sha = ''.join(['#' for i in range(w + 2)])
a = [sha]

for j in range(h):
    a.append('#' + input() + '#')

a.append(sha)

for k in a:
    print(k)
