W,H=map(int,raw_input().split())
if(W%16==0 and H%9==0 and W>=16 and H>=9):
    print("16:9")
else:
    print("4:3")