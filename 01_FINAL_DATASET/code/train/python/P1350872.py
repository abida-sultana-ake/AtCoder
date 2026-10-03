
def f(scores):
    res = sum(scores)
    if res % 10 == 0:
        candidates = list(score for score in scores if score % 10 != 0)
        if candidates:
            res -= min(candidates)
        else:
            res = 0
    return res
 
N = int(input())
scores = []
for _ in range(N):
    scores.append(int(input()))
print(f(scores))