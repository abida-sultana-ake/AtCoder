
def main():
    [n, a, b] = list(map(int,input().split()))
    m = list(map(int,input().split()))
    cost = 0
    for i in range(1, n):
        cost += min([a*(m[i]-m[i-1]), b])
    print(cost)


if __name__ == "__main__":
    import sys
    import os
    if len(sys.argv) > 1:
        if sys.argv[1] == "-d":
            filename = "input1.txt"
            fd = os.open(filename, os.O_RDONLY)
            os.dup2(fd, sys.stdin.fileno())
            main()
    else:
        main()