def solve():
    a, b = map(int, input().split())
    if a + b >= 24:
        print(a + b - 24)
    else:
        print(a + b)

if __name__ == "__main__":
    solve()