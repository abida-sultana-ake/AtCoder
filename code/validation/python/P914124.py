from collections import defaultdict
if __name__ == '__main__':
    h, w, n = [int(x) for x in input().split()]
    coords = []
    count = defaultdict(int)
    ans = [0 for x in range(10)]
    ans[0] = (h-2) * (w-2)
    adjacent = [(-1, 1), (0, 1), (1, 1), (-1, 0), (0, 0), (1, 0), (-1, -1), (0, -1), (1, -1)]
    for i in range(n):
        y, x = [int(v) for v in input().split()]
        coords.append((x,y))
    for x,y in coords:
        for dx, dy in adjacent:
            new_x = x + dx
            new_y = y + dy
            if 2 <= new_x <= w-1 and 2 <= new_y <= h-1:
                count[(new_x, new_y)] += 1
    for i in count.values():
        ans[i] += 1
        ans[0] -= 1

    for a in ans:
        print(a)