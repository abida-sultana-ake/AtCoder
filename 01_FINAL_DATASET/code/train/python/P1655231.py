# -*- coding: utf-8 -*-

from decimal import Decimal, ROUND_HALF_UP

# 入力の数値
deg, dis = map(int, input().split())

# 風向の場合分け
deg /= 10
direction = "N"
if 11.25 <= deg < 33.75:
	direction = "NNE"
elif 33.75 <= deg < 56.25:
	direction = "NE"
elif 56.25 <= deg < 78.75:
	direction = "ENE"
elif 78.75 <= deg < 101.25:
	direction = "E"
elif 101.25 <= deg < 123.75:
	direction = "ESE"
elif 123.75 <= deg < 146.25:
	direction = "SE"
elif 146.25 <= deg < 168.75:
	direction = "SSE"
elif 168.75 <= deg < 191.25:
	direction = "S"
elif 191.25 <= deg < 213.75:
	direction = "SSW"
elif 213.75 <= deg < 236.25:
	direction = "SW"
elif 236.25 <= deg < 258.75:
	direction = "WSW"
elif 258.75 <= deg < 281.25:
	direction = "W"
elif 281.25 <= deg < 303.75:
	direction = "WNW"
elif 303.75 <= deg < 326.25:
	direction = "NW"
elif 326.25 <= deg < 348.75:
	direction = "NNW"

# 風程を風速にする
speed = dis / 60
# 小数第2位を四捨五入(python3はroundだといけない)
num1 = Decimal(str(speed))
num1 = num1.quantize(Decimal(".1"), ROUND_HALF_UP)
speed = float(num1)

# 風力の場合分け
if 0.0 <= speed <= 0.2:
	wind = "0"
elif 0.3 <= speed <= 1.5:
	wind = "1"
elif 1.6 <= speed <= 3.3:
	wind = "2"
elif 3.4 <= speed <= 5.4:
	wind = "3"
elif 5.5 <= speed <= 7.9:
	wind = "4"
elif 8.0 <= speed <= 10.7:
	wind = "5"
elif 10.8 <= speed <= 13.8:
	wind = "6"
elif 13.9 <= speed <= 17.1:
	wind = "7"
elif 17.2 <= speed <= 20.7:
	wind = "8"
elif 20.8 <= speed <= 24.4:
	wind = "9"
elif 24.5 <= speed <= 28.4:
	wind = "10"
elif 28.5 <= speed <= 32.6:
	wind = "11"
elif speed >= 32.7:
	wind = "12"

# 風力が0なら風向はCで確定
if wind == "0":
	direction = "C"

print(direction + " " + wind)