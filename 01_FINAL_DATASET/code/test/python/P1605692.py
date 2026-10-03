l,h=map(int,input().split());n=int(input())
for j in map(lambda x:l-x if x<l else-1if x>h else 0,[int(input())for i in[0]*n]):print(j)