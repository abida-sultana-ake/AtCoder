date=[int(i) for i in input().split('/')]

def uruu_feb(year):
    if year%4==0 and year%100!=0 or year%400==0:return 29
    else:return 28
    
def how_many_days(date):
    if date[1] in [4,6,9,11]:return 30
    elif date[1] is 2:return uruu_feb(date[0])
    else: return 31
    
def iterate(date):
    while True:
        if date[0]%(date[1]*date[2])==0: break
        date[2]+=1
        if date[2]>how_many_days(date):
            date[2]=1
            date[1]+=1
            if date[1]>12:
                date[1]=1
                date[0]+=1
    return date

def makeAns(date):
    sArray=[]
    for d in date:
        s=''
        if d<10:s='0'+str(d)
        else: s=str(d)
        sArray.append(s)
    return '/'.join(sArray)

print(makeAns(iterate(date)))