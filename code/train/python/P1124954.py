XY = map(float, raw_input().split())
X, Y = XY[::2], XY[1::2]
midX, midY = (min(X)+max(X))/2, (min(Y)+max(Y))/2
X, Y = map(lambda x: x-midX, X), map(lambda x: x-midY, Y)
print (abs(X[0]*Y[1]-X[1]*Y[0]) + abs(X[1]*Y[2]-X[2]*Y[1]) + abs(X[2]*Y[0]-X[0]*Y[2]))/2