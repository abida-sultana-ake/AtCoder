m=float(input())
M=m*10**(-3)
if M<0.1:
    VV=0
elif 0.1<=M<=5:
    VV=M*10
elif 6<=M<=30:
    VV=M+50
elif 35<=M<=70:
    VV=(M-30)//5.0+80
elif 70<=M:
    VV=89
print ("{0:02d}".format(int(VV)))