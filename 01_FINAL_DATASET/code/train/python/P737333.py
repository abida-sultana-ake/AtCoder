# coding: utf-8
 
def main():
    L,X,Y,S,D = map(int,raw_input().split())
 
    #tokeimawari
    if D >= S:
        a = (D-S)/(X+Y*1.0)
    else:
        a = (D+L-S)/(X+Y*1.0)
 
    #hantokeimawari
    if Y-X > 0:
        if D < S:
            b = (S-D)/(Y-X*1.0)
        else:
            b = (S+L-D)/(Y-X*1.0)
    else:
        b = float("inf")
 
    print(min(a,b))
 
if __name__ == "__main__":
    main()