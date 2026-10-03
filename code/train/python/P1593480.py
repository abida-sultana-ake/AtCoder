def f1(Deg):
    d = ['NNE', 'NE', 'ENE', 'E', 'ESE', 'SE', 'SSE',
    'S', 'SSW', 'SW', 'WSW', 'W', 'WNW', 'NW', 'NNW']
    if Deg < 112.5 or Deg >= 3487.5:
        return 'N'
    for i in range(len(d)):
        a = 337.5 + i * 225
        if Deg < a:
            return d[i]

def f2(Dis):
    v = [0.0, 0.3, 1.6, 3.4, 5.5, 8.0, 10.8, 13.9, 17.2, 20.8, 24.5, 28.5, 32.7]
    v = [x - 0.05 for x in v]
    v[0] = 0.0
    for i in range(12, -1, -1):
        if Dis >= 60*v[i]-1e-6:
            return i

Deg, Dis = list(map(int, input().split()))
Dir = f1(Deg)
W = f2(Dis)
if W == 0:
    Dir = 'C'
print(Dir, W)