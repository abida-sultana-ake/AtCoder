N = int(input())
vote = [1,1]
for i in range(N):
    ratio = list(map(int, input().split()))
    for j in range(2):
        while(vote[j] % ratio[j] != 0):
            vote[j] += 1
    if vote[0] * ratio[1] < vote[1] * ratio[0]:
        vote[0] = vote[1] // ratio[1] * ratio[0];
    if vote[0] * ratio[1] > vote[1] * ratio[0]:
        vote[1] = vote[0] // ratio[0] * ratio[1];
print(vote[0] + vote[1])