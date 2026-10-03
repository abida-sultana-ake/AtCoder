card = [input(), input(), input()]
ne = 0

while 1:
    if not len(card[ne]):
        print(chr(ord('A') + ne))
        break
    a = ord(card[ne][0]) - ord('a')
    card[ne] = card[ne][1:]
    ne = a
