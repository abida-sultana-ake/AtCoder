print((lambda N, A: len(set(A)) - (N - len(set(A))) % 2)(int(input()), list(map(int, input().split()))))
