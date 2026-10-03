def myround(x, d=0):
    p = 10 ** d
    return (x * p * 2 + 1) // 2 / p

deg, dis = map(int, input().split())

if(deg >= 112.5 and deg < 337.5):
    Dir = "NNE"
elif(deg >= 337.5 and deg < 562.5):
    Dir = "NE"
elif(deg >= 562.5 and deg < 787.5):
    Dir = "ENE"
elif(deg >= 787.5 and deg < 1012.5):
    Dir = "E"
elif(deg >= 1012.5 and deg < 1237.5):
    Dir = "ESE"
elif(deg >= 1237.5 and deg < 1462.5):
    Dir = "SE"
elif(deg >= 1462.5 and deg < 1687.5):
    Dir = "SSE"
elif(deg >= 1678.5 and deg < 1912.5):
    Dir = "S"
elif(deg >= 1912.5 and deg < 2137.5):
    Dir = "SSW"
elif(deg >= 1912.5 and deg < 2137.5):
    Dir = "SSW"
elif(deg >= 2137.5 and deg < 2362.5):
    Dir = "SW"
elif(deg >= 2362.5 and deg < 2587.5):
    Dir = "WSW"
elif(deg >= 2587.5 and deg < 2812.5):
    Dir = "W"
elif(deg >= 2812.5 and deg < 3037.5):
    Dir = "WNW"
elif(deg >= 3037.5 and deg < 3262.5):
    Dir = "NW"
elif(deg >= 3262.5 and deg < 3487.5):
    Dir = "NNW"
else:
    Dir = "N"

WS = myround(dis / 60, 1)
if(WS <= 0.2):
    Dir = "C"
    W = 0
elif(WS <= 1.5):
    W = 1
elif(WS <= 3.3):
    W = 2
elif(WS <= 5.4):
    W = 3
elif(WS <= 7.9):
    W = 4
elif(WS <= 10.7):
    W = 5
elif(WS <= 13.8):
    W = 6
elif(WS <= 17.1):
    W = 7
elif(WS <= 20.7):
    W = 8
elif(WS <= 24.4):
    W = 9
elif(WS <= 28.4):
    W = 10
elif(WS <= 32.6):
    W = 11
else:
    W = 12

print("{0} {1}".format(Dir, W))
