if __name__ == '__main__':
    n = int(input())
    h , m , s = n//(60**2) , (n//60)%60 , n%60

    if h/10 < 1:
        h = "0"+str(h)
    else:
        h = str(h)

    if m/10 < 1:
        m = "0"+str(m)
    else:
        m = str(m)

    if s/10 < 1:
        s = "0"+str(s)
    else:
        s = str(s)

    print(h+":"+m+":"+s)
