N, K = map(int, input().split())
points = [tuple(map(int, input().split())) for i in range(N)]

ptsX = sorted(points, key=lambda t: t[0])
ptsY = sorted(points, key=lambda t: t[1])

ans = float('inf')
for iLeft, ptLeft in enumerate(ptsX):
    setX = set(ptsX[iLeft:])

    for ptRight in ptsX[iLeft + 1:][::-1]:
        if len(setX) < K: break
        lenX = ptRight[0] - ptLeft[0]

        for iBottom, ptBottom in enumerate(ptsY):
            setY = set(ptsY[iBottom:])

            for ptTop in ptsY[iBottom + 1:][::-1]:
                if len(setY) < K: break

                num = len(setX & setY)
                if num < K: break

                if num == K:
                    lenY = ptTop[1] - ptBottom[1]
                    area = lenX * lenY
                    ans = min(ans, area)

                setY.remove(ptTop)

        setX.remove(ptRight)

print(ans)
