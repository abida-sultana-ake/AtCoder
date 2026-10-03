
def fuko(deg):
    x = deg/10
    if 11.25 <= x and x < 33.75:
        return "NNE"
    if 33.75 <= x and x < 56.25:
        return "NE"
    if 56.25 <= x and x < 78.75:
        return "ENE"
    if 78.75 <= x and x < 101.25:
        return "E"
    if 101.25 <= x and x < 123.75:
        return "ESE"
    if 123.75 <= x and x < 146.25:
        return "SE"
    if 146.25 <= x and x < 168.75:
        return "SSE"
    if 168.75 <= x and x < 191.25:
        return "S"
    if 191.25 <= x and x < 213.75:
        return "SSW"
    if 213.75 <= x and x < 236.25:
        return "SW"
    if 236.25 <= x and x < 258.75:
        return "WSW"
    if 258.75 <= x and x < 281.25:
        return "W"
    if 281.25 <= x and x < 303.75:
        return "WNW"
    if 303.75 <= x and x < 326.25:
        return "NW"
    if 326.25 <= x and x < 348.75:
        return "NNW"
    return "N"

def furyoku(dis):
    myround =lambda x:(x*2+1)//2

    fusoku = myround(dis/6)/10

    if fusoku <=0.2:
        return 0
    if 0.3 <= fusoku <= 1.5:
        return 1
    if fusoku <= 3.3:
        return 2
    if fusoku <= 5.4:
        return 3
    if fusoku <= 7.9:
        return 4
    if fusoku <= 10.7:
        return 5
    if fusoku <= 13.8:
        return 6
    if fusoku <= 17.1:
        return 7
    if fusoku <= 20.7:
        return 8
    if fusoku <= 24.4:
        return 9
    if fusoku <= 28.4:
        return 10
    if fusoku <= 32.6:
        return 11
    if 32.7 <= fusoku:
        return 12
    return 0

def kaitou( fk, fr):
    out_furyoku = furyoku(fr)
    out_fuko = fuko(fk)
    if out_furyoku == 0:
        return "C 0"
    else:
        return out_fuko +" "+ (str)(out_furyoku)

if __name__ == '__main__':
    given_1,given_2 = map(int,(input().split()))
    print(kaitou(given_1,given_2))

