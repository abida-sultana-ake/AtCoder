if(__name__ == "__main__"):
    a, b =[int(i) for i in input().split()]
    #print(a,b)
    if(a > 0 and b > 0):
        if((a+b) % 3 == 0 or a % 3 == 0 or b % 3 == 0):
            print("Possible")
        else:
            print("Impossible")
    else:
        print("Impossible")
    