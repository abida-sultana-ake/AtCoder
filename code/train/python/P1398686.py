if(__name__ =="__main__"):
    S = input()
    for i in range(1,len(S)):
        tmp = S[:-i]
        tmplen = len(tmp)
        #print(tmplen)
        if(tmplen % 2 == 0):
            #print(tmp[:int(tmplen/2)])
            if(tmp[:int(tmplen/2)] == tmp[int(tmplen/2):]):
                print(tmplen)
                break