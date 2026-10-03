# coding: utf-8
def get_ln_inputs():
    return input().split()


def get_ln_int_inputs():
    return list(map(int, get_ln_inputs()))


DIRECTIONS = ["N", "NNE", "NE", "ENE", "E", "ESE", "SE", "SSE", "S", "SSW", "SW", "WSW", "W", "WNW", "NW", "NNW"]
BEAUFORT_SCALE_THRESHOLDS = [0.2, 1.5, 3.3, 5.4, 7.9, 10.7, 13.8, 17.1, 20.7, 24.4, 28.4, 32.6]


def get_dir(deg, beaufort_scale):
    if beaufort_scale == 0:
        return "C"

    shifted_deg = deg + (360 / 32)
    if shifted_deg > 360:
        shifted_deg -= 360

    return DIRECTIONS[int(shifted_deg // (360 / 16))]


def get_beaufort_scale(speed):
    scale = 0
    while scale < len(BEAUFORT_SCALE_THRESHOLDS) and speed > BEAUFORT_SCALE_THRESHOLDS[scale]:
        scale += 1
    return scale


def main():
    deg, dis = get_ln_int_inputs()
    w = get_beaufort_scale(round(dis / 60 + 0.000001, 1))
    dir = get_dir(deg / 10, w)
    print(dir + " " + str(w))


main()