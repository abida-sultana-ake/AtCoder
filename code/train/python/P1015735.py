#coding: utf-8;

def check(h, w, fs, ts, sl, tsl):
    for i in range(h):
        for j in range(w):
            if sl[i][j] == fs: continue
            tsl[i][j] = ts
            if i > 0: tsl[i - 1][j] = ts
            if h > i + 1: tsl[i + 1][j] = ts
            if j > 0: tsl[i][j - 1] = ts
            if w > j + 1: tsl[i][j + 1] = ts
            if h > i + 1 and w > j + 1: tsl[i + 1][j + 1] = ts
            if i > 0 and j > 0: tsl[i - 1][j - 1] = ts
            if h > i + 1 and j > 0: tsl[i + 1][j - 1] = ts
            if i > 0 and w > j + 1: tsl[i - 1][j + 1] = ts
    return tsl

def main():
    h, w = map(int, input().split())
    sl = [list(input()) for _ in range(h)]
    tsl = [['#' for _ in range(w)] for _ in range(h)]
    ttsl = [['.' for _ in range(w)] for _ in range(h)]

    tsl = check(h, w, '#', '.', sl, tsl)
    ttsl = check(h, w, '.', '#', tsl, ttsl)

    if ttsl == sl:
        print('possible')
        for s in tsl:
            print(''.join(s))
    else:
        print('impossible')

if __name__ == '__main__':
    main()
