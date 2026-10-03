n = int(input())
vote = {}

for i in range(n):
    s = input()
    if s in vote:
        vote[s] += 1
        if vote[max_voted] <= vote[s]:
            max_voted = s
    else:
        vote[s] = 1
        if len(vote) == 1:
            max_voted = s

print(max_voted)