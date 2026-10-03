def cal(i,P):
    if i == 0:
        return P
    return i + P/(2**(i/1.5))

def solve(a,b,P):
    if abs(a-b)<10**(-10):
        return cal(a,P)
    ma = cal(a,P)
    mb = cal(b,P)
    m = (a+b)/2
    mm = cal(m,P)
    mml = cal(m-10**(-8),P);
    if mml < mm:
        return solve(a,m,P)
    else:
        return solve(m,b,P)




P = float(input())

print(solve(0,1000,P))