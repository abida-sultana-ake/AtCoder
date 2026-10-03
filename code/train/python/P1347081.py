time = int(input())
kakko = input()
hidarikakko = 0 #(
migikakko = 0 #)
hidariHuyasu = 0 #左に増やす(の数
migiHuyasu = 0 #右に
#左に増やすのを考える
for i in range(time):
    if kakko[i] == "(":
        hidarikakko += 1
    else:
        if hidarikakko == 0:
            hidariHuyasu += 1
        else:
            hidarikakko -= 1
#右に増やすのを考える
hidarikakko = 0 #(
migikakko = 0 #)
gyaku = range(time)
# print(gyaku)
# gyaku.reverse()
for i in reversed(range(time)):
    if kakko[i] == ")":
        migikakko += 1
    else:
        if migikakko == 0:
            migiHuyasu += 1
        else:
            migikakko -= 1
print("(" * hidariHuyasu + kakko + ")" * migiHuyasu)