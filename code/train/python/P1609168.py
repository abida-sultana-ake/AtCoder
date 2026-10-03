N = int(input())
m = list(map(int, input().split()))
print(sum([max(0, 80-x) for x in m]))