if __name__=="__main__":
    n = int(input())
    As = list(map(int,input().split()))
    Non_dup_As = list(set(As))
    count = len(Non_dup_As)
    if(count % 2 == 0):
        print(count - 1)
    else:
        print(count)
