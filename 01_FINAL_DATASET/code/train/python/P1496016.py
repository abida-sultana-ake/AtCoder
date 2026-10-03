from collections import defaultdict

def rotate(field):
    ans = [[0] * len(field[0]) for _ in range(len(field))]
    for i in range(len(field)):
        for j in range(len(field[0])):
            ans[j][len(field) - i - 1] = field[i][j]
    return ans


def main():
    N = int(input())
    field = [input() for _ in range(N)]

    r = rotate(field)
    for line in r:
        print("".join(line))

if __name__ == '__main__':
    main()
