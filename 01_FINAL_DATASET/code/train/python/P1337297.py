Deg, Dis = map(int, input().split(" "))
Dir = ["N", "NNE", "NE", "ENE", "E", "ESE", "SE", "SSE", "S", "SSW", "SW", "WSW", "W", "WNW", "NW", "NNW", "N"][(Deg+112)//225]
W = len(list(filter(lambda x: x < (Dis+3)//6, [2, 15, 33, 54, 79, 107, 138, 171, 207, 244, 284, 326])))
print(Dir if W != 0 else "C", W)