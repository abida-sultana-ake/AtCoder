N = int(input())
list_card = list(map(int, input().split()))
##count = 0
##for x in set(list_card):
##    count += list_card.count(x) - 1
M = N - len(set(list_card))
print(N - (M + M%2))
