from collections import defaultdict


def solve(s, l):

    for i in range(1, len(s) - 1):
        # ひつじ
        if l[i] == 1:
            if s[i] == "o":
                l[i + 1] = l[i - 1]
            else:
                l[i + 1] = -1 * l[i - 1]
        # おおかみ
        else:
            if s[i] == "o":
                l[i + 1] = -1 * l[i - 1]
            else:
                l[i + 1] = l[i - 1]

    if l[0] == 1:
        if s[0] == "o":
            ok1 = l[1] == l[-1]
        else:
            ok1 = l[1] != l[-1]
    # おおかみ
    else:
        if s[0] == "o":
            ok1 = l[1] != l[-1]
        else:
            ok1 = l[1] == l[-1]

    if l[-1] == 1:
        if s[-1] == "o":
            ok2 = l[0] == l[-2]
        else:
            ok2 = l[0] != l[-2]
    # おおかみ
    else:
        if s[-1] == "o":
            ok2 = l[0] != l[-2]
        else:
            ok2 = l[0] == l[-2]

    return ok1 and ok2

def main():
    N = int(input())
    S = input()
    ans = [None] * N
    ans[0] = 1
    ans[1] = 1
    if solve(S, ans):
        print(*["S" if x == 1 else "W" for x in ans], sep="")
        return

    ans = [None] * N
    ans[0] = 1
    ans[1] = -1
    if solve(S, ans):
        print(*["S" if x == 1 else "W" for x in ans], sep="")
        return

    ans = [None] * N
    ans[0] = -1
    ans[1] = 1
    if solve(S, ans):
        print(*["S" if x == 1 else "W" for x in ans], sep="")
        return

    ans = [None] * N
    ans[0] = -1
    ans[1] = -1
    if solve(S, ans):
        print(*["S" if x == 1 else "W" for x in ans], sep="")
        return

    print(-1)


if __name__ == '__main__':
    main()
