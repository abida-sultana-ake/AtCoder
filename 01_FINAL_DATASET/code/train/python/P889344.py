s={}
for i in range(3):
    s[chr(97+i)]=input()
turn="a"
while True:
    if not s[turn]:
        break
    else:
        t=s[turn][0]
        s[turn]=s[turn][1:]
        turn=t
print(turn.upper())
