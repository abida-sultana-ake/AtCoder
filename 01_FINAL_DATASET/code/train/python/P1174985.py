from math import log2 as log2

def tmin(x,n):
    if x > n:
        return 0
    return tmin(x*2,n) + 1

def tmax(x,n):
    if x > n:
        return 0
    return tmax(x*2+1,n) + 1

def isComp(x,n):
    return tmin(x,n) == tmax(x,n)

def getDepth(x,n):
    if x > n:
        return 0
    return getDepth(2*x,n) + 1

def rec(x,n,phase): # False -> Takahashi
#print("x = " + str(x) + ", n = " + str(n) + ", phase = " + str(phase))
    if x > n:
        return ["Takahashi","Aoki"][phase]
    if x * 2 + 1 > n:
        return rec(x*2,n,not phase)
    if isComp(x,n):
        dep = getDepth(x,n) - 1
        #print("dep = " + str(dep))
        if dep % 2 == 1:
            return ["Takahashi","Aoki"][phase]
        else:
            return ["Takahashi","Aoki"][not phase]
    lef = isComp(x*2,n)
    rig = isComp(x*2+1,n)
    #print("lef = " + str(lef) + ", rig = " + str(rig))
    if lef and rig:
        dep_lef = getDepth(x*2,n) - 1
        dep_rig = getDepth(x*2+1,n) - 1
        if dep_lef % 2 == 1:
            return ["Takahashi","Aoki"][phase]
        if dep_rig % 2 == 1:
            return ["Takahashi","Aoki"][phase]
        return ["Takahashi","Aoki"][not phase]
    if lef:
        dep = getDepth(x*2,n) 
    else:
        dep = getDepth(x*2+1,n)
    #print("depth = " + str(dep))
    if dep % 2 == 1:
        return ["Takahashi","Aoki"][phase]
    else:
        if lef:
            return rec(x*2+1,n,not phase)
        else:
            return rec(x*2,n,not phase)

def main():
    n = int(input())
    print(rec(1,n,False))

if __name__ == "__main__":
    main()

