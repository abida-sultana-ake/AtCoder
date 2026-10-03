import sys
i=0
j=0
k=0
t=0
m=0
s=0
lists=[]
lists2 =[]

#数値の数を受け取る
line = int(input())

#数値を受け取ってリストの作成
while i < line:
	a = int(input())
	#print (a)
	lists.insert(i,a)
	i +=1

#数値の足し合わせ
while j < line:
    s += lists[j]
    j +=1

#正しければ出力
if s%10 != 0:
	print(s)
else:
    #10の倍数以外のリスト作成
    while k < line:
        if lists[k]%10 != 0:
	        lists2.insert(m,lists[k])
	        m +=1
        k +=1
    if lists2 !=[]:
        t = min(lists2)
        print(s-t)
    else:
    	print(0)