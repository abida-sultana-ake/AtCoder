sx,sy,tx,ty = map(int,input().split())
route = ''
x_diff = tx - sx
y_diff = ty - sy

#行き1の経路:y軸から移動,x軸最後に移動
for i in range(y_diff):
    route += 'U'
for i in range(x_diff):
    route += 'R'

#帰り1の経路:y軸降りる,x軸左に
for i in range(y_diff):
    route += 'D'
for i in range(x_diff):
    route += 'L'

#行き2の経路:左に1ずれ,上にy_diff+1移動した後x_diff+1移動し1降りる
route += 'L'
for i in range(y_diff+1):
    route += 'U'
for i in range(x_diff+1):
    route += 'R'
route += 'D'

#帰り2の経路:右1ずれ,下y_diff+1移動,x_diff+1左移動し1上に
route += 'R'
for i in range(y_diff+1):
    route += 'D'
for i in range(x_diff+1):
    route += 'L'
route += 'U'
print(route)