S = input()

oto = ["Do", "Re", "Mi", "Fa", "So", "La", "Si"]

kenban = "WWBWBWWBWBWB"

o = -1

while True:
    kenban = kenban[1:] + kenban[:1]
    if kenban[0] is not "W":
        continue
    o = o + 1

    if (S.find(kenban) == 0):
        print(oto[o])
        exit()

