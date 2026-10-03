import math

def main():
    a = "WBWBW"
    b = "BW"
    # WBWBWWBWBWBWW.BWBWWBWB|WBWW.BWBWWBWBWBWWBWBWWBWBWBWWBWBWWBWBWBWWBWBWWBWBWBW
    c = a + a + b;
    x = input()
    out = ["Do", "Si"," ", "La", " ","So"," ", "Fa", "Mi", " ","Re", " "]
    # list = [1,1,1,1,1,1,1,1,1,1]
    # list[0] = "WBWBWWBWBWBWWBWBWWBWB"
    # list[1] = "WBWWBWBWBWWBWBWWBWBWB"
    # list[2] = "WWBWBWBWWBWBWWBWBWBWW"
    # list[3] = "WBWBWBWWBWBWWBWBWBWWB"
    # list[4] = "WBWBWWBWBWWBWBWBWWBWB"
    # list[5] = "WBWWBWBWWBWBWBWWBWBWW"
    # list[6] = "WWBWBWWBWBWBWWBWBWWBW"
    # list[7] = "WBWBWWBWBWBWWBWBWWBWB"
    # list[8] = "WBWWBWBWBWWBWBWWBWBWB"
    # list[9] = "WWBWBWBWWBWBWWBWBWBWW"

    # for sth in list:
    # print(sth.find(c))
    if(x.find(c) == -1):
         print("Re")
    else:
        print(out[x.find(c) % 12])

    # out.reverse()
    # print(x.find(c))
    # print(out[x.find(c) % 12])

if __name__ == "__main__":
    main()
