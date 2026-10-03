n=int(input())
a=list(map(int,input().split()))
choice=0
colour={}
for elements in a:
	if elements>=1 and elements<=399:colour[1]=1
	elif elements>=400 and elements<=799:colour[2]=2
	elif elements>=800 and elements<=1199:colour[3]=3
	elif elements>=1200 and elements<=1599:colour[4]=4
	elif elements>=1600 and elements<=1999:colour[5]=5
	elif elements>=2000 and elements<=2399:colour[6]=6
	elif elements>=2400 and elements<=2799:colour[7]=7
	elif elements>=2800 and elements<=3199:colour[8]=8
	else:choice+=1

m=len(colour)
if m==0 and choice!=0:m=1
print(m,len(colour)+choice)
