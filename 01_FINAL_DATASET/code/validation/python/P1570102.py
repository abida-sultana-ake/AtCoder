if __name__ == '__main__':
    r, c = map(int,input().split())
    sy, sx = map(int,input().split())
    gy, gx = map(int,input().split())
    map = []
    for _ in range(r):
        map.append(list(input()))
    
    map[sy-1][sx-1] = 0

    tmpList = []
    tmpList.append([sy-1,sx-1])

    while map[gy-1][gx-1] == '.':
        nextList = []
        for tmpListElement in tmpList:
            for x in [[-1,0],[1,0],[0,-1],[0,1]]:
                if map[tmpListElement[0]+x[0]][tmpListElement[1]+x[1]] == '.':
                    map[tmpListElement[0]+x[0]][tmpListElement[1]+x[1]] = map[tmpListElement[0]][tmpListElement[1]]+1
                    nextList.append([tmpListElement[0]+x[0],tmpListElement[1]+x[1]])
        tmpList = nextList

    print(map[gy-1][gx-1])
