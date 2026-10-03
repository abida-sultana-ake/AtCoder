import bisect
INF = 10 ** 10


class Box:
    def __init__(self, w, h):
        self.w = w
        self.h = h

    def __lt__(self, other):
        return self.h < other.h

    def __repr__(self):
        return "({0}, {1})".format(self.w, self.h)


def solve(l):

    box_list = [Box(w, h) for w, h in l]

    dp = [box_list[0]]
    for box in box_list[1:]:
        if dp[-1].w < box.w and dp[-1].h < box.h:
            dp.append(box)
        else:
            i = bisect.bisect_left(dp, box)
            if i < len(dp):
                dp[i] = min(dp[i], box)
    return len(dp)


def main():
    N = int(input())
    l = []
    for _ in range(N):
        w, h = map(int, input().split())
        l.append((w, h))

    l.sort(key=lambda x: x[1], reverse=True)
    l.sort(key=lambda x: x[0])
    print(solve(l))

if __name__ == '__main__':
    main()
