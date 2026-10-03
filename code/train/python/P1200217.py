import sys

def solve():
    a = [int(i) for i in input().split()]
    nums = [False] * (500 + 1)
    cnt = 0

    for i in range(5):
        for j in range(i + 1, 5):
            for k in range(j + 1, 5):
                nums[(a[i] + a[j] + a[k])] = True

    for i in range(500, -1, -1):
        if nums[i]:
            cnt += 1

            if cnt == 3:
                print(i)
                return


def debug(x, table):
    for name, val in table.items():
        if x is val:
            print('DEBUG:{} -> {}'.format(name, val), file=sys.stderr)
            return None

if __name__ == '__main__':
    solve()