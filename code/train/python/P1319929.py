def gcd(a,b):
    if b==0:
        return a
    else:
        return gcd(b,a%b)

def solve():
    a,b,c=map(int,input().split())
    if c%gcd(a,b)==0:
        print("YES")
    else:
        print("NO")

if __name__ == "__main__":
    solve()