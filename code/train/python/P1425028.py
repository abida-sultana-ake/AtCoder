# -*- coding: utf-8 -*-

#すぬけくんは 3 匹のヤギにクッキーを渡したいです。
#すぬけくんは A 枚のクッキーが入った缶と、B 枚のクッキーが入った缶を持っています。
#すぬけくんは A,B,A+B のいずれかの枚数のクッキーをヤギたちに渡すことができます。
#3 匹のヤギが同じ枚数ずつ食べられるようにクッキーを渡すことが可能かどうか判定してください。
#3 匹のヤギが同じ枚数ずつ食べられるようにクッキーを渡すことが可能ならば Possible と、
#そうでなければ Impossible と出力せよ。

A = input().split()
#A = [3, 3]
x = int(A[0])
y = int(A[1])

if x % 3 ==0:
    print("Possible")

elif y % 3 ==0:
    print("Possible")
    
elif (x + y) % 3 ==0:
    print("Possible")

    
else:
    print("Impossible")
    

