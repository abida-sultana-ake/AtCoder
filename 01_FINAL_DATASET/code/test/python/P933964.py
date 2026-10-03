N = int(input())
TA = []
for i in range(N):
	TA.append(list(map(int, input().split())))
 
TA.reverse()
(voteA, voteB) = (1,1)
while TA:
	(Ti, Ai) = TA.pop()
	tmp = max((voteA + Ti -1) // Ti, (voteB + Ai -1) // Ai)
	voteA = Ti * tmp
	voteB = Ai * tmp
print(voteA + voteB)