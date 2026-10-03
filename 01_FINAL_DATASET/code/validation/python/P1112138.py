def solve(n, s):
    prev = 'b'
    if s == 'b':
        return 0
    first = "bac"
    last = "bca"
    for i in range(1, n // 2 + 1):
        prev = first[i % 3] + prev + last[i % 3]
        if s == prev:
            return i
    return -1

if __name__ == "__main__":
    n = int(input())
    s = input()
    print(solve(n, s))
