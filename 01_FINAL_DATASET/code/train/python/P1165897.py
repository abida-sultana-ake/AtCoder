# -*- coding: utf-8 -*-

def main():
    deg, dis = map(int, input().split())

    wind_direction = get_wind_direction(deg)
    wind_scale = get_wind_scale(dis)

    if wind_scale == 0:
        wind_direction = 'C'

    print(wind_direction, wind_scale)


def get_wind_direction(deg):
    direction = [
        'N', 'NNE', 'NE', 'ENE', 'E', 'ESE', 'SE', 'SSE',
        'S', 'SSW', 'SW', 'WSW', 'W', 'WNW', 'NW', 'NNW'
    ]

    degree = deg * 10

    for i in range(1, len(direction)):
        lower_limit = 1125 + 2250 * (i - 1)
        upper_limit = 1125 + 2250 * i
        if lower_limit <= degree < upper_limit:
            return direction[i]

    # N
    return direction[0]


def get_wind_scale(dis):
    velocity = [
        0.0, 0.3, 1.6, 3.4, 5.5, 8.0, 10.8,
        13.9, 17.2, 20.8, 24.5, 28.5, 32.7
    ]

    distance = dis * 10

    for i in range(len(velocity) - 1):
        lower_limit = (velocity[i] * 10 - 0.5) * 60
        upper_limit = (velocity[i + 1] * 10 - 0.5) * 60
        if lower_limit <= distance < upper_limit:
            return i

    if distance >= (velocity[-1] * 10 - 0.5) * 60:
        return 12


if __name__ == '__main__':
    main()