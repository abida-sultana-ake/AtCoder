def main():
    N =  int(input())
    a = [int(i) for i in input().split()]
    #print(N)
    #print(a)
    
    count_ = [0] * ( max(a)+2 )
    #print(len(count_))
    #a_plus  = [ i+1 for i in a ]
    #a_sub = [ i-1 for i in a ]
    #print( [ i+1 for i in a ] )
    
    for num in a:
        if(num > 0):
            count_[num-1] += 1
            count_[num] += 1
            count_[num+1] += 1
        else:
            count_[num] += 1
            count_[num+1] += 1
    
    #print(count_)
    print(max(count_))
    
if __name__=="__main__":
    main()