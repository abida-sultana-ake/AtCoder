import datetime
date = input()
d = datetime.datetime.strptime(date, "%Y/%m/%d")

def divDay(d):
    date = d.strftime("%Y/%m/%d")
    Y, M, D = list(map(int, date.split("/")))
    if (Y%(M*D) == 0):
        return True
    else:
        return  False

if divDay(d):
    print(d.strftime("%Y/%m/%d"))
else:
    while not divDay(d) :
        d += datetime.timedelta(days=1)
    print(d.strftime("%Y/%m/%d"))