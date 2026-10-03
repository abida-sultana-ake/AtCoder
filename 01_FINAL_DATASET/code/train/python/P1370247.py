import itertools

if __name__ == '__main__':
    answer = 1

    given_n = 5
    given_m = 3
    a = [[1-1,2-1],[2-1,3-1],[1-1,3-1]]

    given_n, given_m = map(int,input().split())

    a = []

    for _ in range(given_m):
        x,y = map(int,input().split())
        a.append([x-1,y-1])


    table_known = [[0 for i in range(given_n)] for j in range(given_n)]

    for tmp in a:
        table_known[tmp[0]][tmp[1]] = 1
        table_known[tmp[1]][tmp[0]] = 1


    giin = list(range(0,given_n))

    isFinished = False

    for t in range(len(giin),1,-1):
        if isFinished == False:
            tmp_comb = list(itertools.combinations(giin,t))
            for comb in tmp_comb:
                tmp_kumi = list(itertools.combinations(comb,2))
                count = 0
                for kumi in tmp_kumi:
                    if table_known[kumi[0]][kumi[1]] == 1:
                        count += 1
                if len(tmp_kumi) == count:
                    answer = t
                    isFinished = True
                    break
    print(answer)


