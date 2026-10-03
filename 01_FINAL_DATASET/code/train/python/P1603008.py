N = int(input())
K = int(input())
x = list(map(int, input().split()))
print(2*sum([min(a, K-a) for a in x]))