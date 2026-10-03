from itertools import combinations as comb

N, M = map(int, input().split())
max_members = range(N)
relation = set()

for _ in range(M):
    x, y = map(int, input().split())
    relation.add((x-1, y-1))
    
def KCS(relation, max_members, k):
    for members in comb(max_members, k):
        for r in comb(members, 2):
            if r not in relation:
                break
        else:
            return True
    else:
        return False
    
right = N+1
left = 1
while right - left > 1:
    mid = (right+left)//2
    if KCS(relation, max_members, mid):
        left = mid
    else:
        right = mid
        
print(left)