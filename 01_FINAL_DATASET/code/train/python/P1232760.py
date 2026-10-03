import sys

def solve():
    a = [int(i) for i in input().split()]
    a.sort()
    print(a[1])
    
if __name__ == '__main__':
    solve()