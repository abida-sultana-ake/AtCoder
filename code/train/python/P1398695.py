def nwse(Dir):
    Dir /= 10
    if 11.25 <= Dir < 33.75: return "NNE"
    elif 33.75 <= Dir < 56.25: return "NE"
    elif 56.25 <= Dir < 78.75: return "ENE"
    elif 78.75 <= Dir < 101.25: return "E"
    elif 101.25 <= Dir < 123.75: return "ESE"
    elif 123.75 <= Dir < 146.25: return "SE"
    elif 146.25 <= Dir < 168.75: return "SSE"
    elif 168.75 <= Dir < 191.25: return "S"
    elif 191.25 <= Dir < 213.75: return "SSW"
    elif 213.75 <= Dir < 236.25: return "SW"
    elif 236.25 <= Dir < 258.75: return "WSW"
    elif 258.75 <= Dir < 281.25: return "W"
    elif 281.25 <= Dir < 303.75: return "WNW"
    elif 303.75 <= Dir < 326.25: return "NW"
    elif 326.25 <= Dir < 348.75: return "NNW"
    else: return "N"
    
def round(x,d=0):
    p=10**d
    return (x*p*2+1)//2/p

def Wip(W):
    W = round((W/60),1)
    if 0.0 <= W <= 0.2: return "0"
    elif 0.3 <= W <= 1.5: return "1"
    elif 1.6 <= W <= 3.3: return "2"
    elif 3.4 <= W <= 5.4: return "3"
    elif 5.5 <= W <= 7.9: return "4"
    elif 8.0 <= W <= 10.7: return "5"
    elif 10.8 <= W <= 13.8: return "6"
    elif 13.9 <= W <= 17.1: return "7"
    elif 17.2 <= W <= 20.7: return "8"
    elif 20.8 <= W <= 24.4: return "9"
    elif 24.5 <= W <= 28.4: return "10"
    elif 28.5 <= W <= 32.6: return "11"
    elif 32.7 <= W: return "12"
    
    
    
Deg,Dis = list(map(int,input().split()))
if Wip(Dis) == "0":
    print("C 0")
else:
    print(nwse(Deg),Wip(Dis))