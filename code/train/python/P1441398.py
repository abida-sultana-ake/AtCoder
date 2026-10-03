nums = [int(x) for x in input().split()]
N,K = nums[0],nums[1]
D = set([int(x) for x in input().split()])

ans = N

def solve(M):
    M = [int(x) for x in str(M)]
    for m in M:
        if m in D: return False
    return True


while(1):
    if solve(ans):
        print(ans)
        break
    else:
        ans +=1