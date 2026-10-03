from collections import defaultdict


def solve(pre_is_positive, a_list):
    total = 0
    ans = 0
    for a in a_list:
        total += a
        if pre_is_positive and total >= 0:
            ans += abs(total) + 1
            total = -1
        elif not pre_is_positive and total <= 0:
            ans += abs(total) + 1
            total = 1
        pre_is_positive = total > 0
    return ans


def main():
    n = int(input())
    a_list = list(map(int, input().split()))
    print(min(solve(True, a_list), solve(False, a_list)))


if __name__ == "__main__":
    main()


          


