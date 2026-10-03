S = input()
N = int(input())
one = (N - 1) // 5
two = N % 5 - 1
print(S[one], end="")
print(S[two])
