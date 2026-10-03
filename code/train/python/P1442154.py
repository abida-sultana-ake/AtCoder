a,b=map(int,input().split())
print(b>14 and"NNE NE ENE E ESE SE SSE S SSW SW WSW W WNW NW NNW N".split()[(a-113)//225]or"C",sum(b>x*6+2 for x in[2,15,33,54,79,107,138,171,207,244,284,326]))