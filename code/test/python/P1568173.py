import sys
keystr = input()
length= input()

if(int(length)>len(keystr)):
    print("0")
    sys.exit()
    pass

if(len(keystr)> 300 or len(keystr)<0):
    print("0")
    sys.exit()
    pass

i=0
list1=[]
while i < len(keystr) :
    tmp=keystr[i:i+int(length)]
    if(len(tmp) == int(length)):
        list1.append(tmp)

    i = i + 1
    pass

list2=[]
i=0
for i in list1:
    if i not in list2:
        list2.append(i)
        pass
    pass

print(len(list2))