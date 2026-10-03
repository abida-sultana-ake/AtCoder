n = int(input())
vote_list = [0]*1000002

for i in range(n):
    a, b = map(int, input().split())
    vote_list[a] += 1
    vote_list[b+1] -= 1
for i in range(len(vote_list) - 1):
    vote_list[i+1] += vote_list[i]

print(max(vote_list))
