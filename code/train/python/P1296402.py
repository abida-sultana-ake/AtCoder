n, m = map(int, input().split())
a = ['#' * (m + 2)] + ['#' + input() + '#' for i in range(n)] + ['#' * (m + 2)]
[print(''.join(i)) for i in a]