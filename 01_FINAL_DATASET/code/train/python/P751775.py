N = int(input())

s = ['1']
s += ['0' for _ in range(N - 1)]
s.append('7')
print(''.join(s))
