L, X, Y, S, D = map(int, input().split())

SpeedCW = X + Y
SpeedCCW = Y - X

if D > S:
    TimeCW = (D - S) / SpeedCW
    if SpeedCCW != 0:
        TimeCCW = (L - D + S) / SpeedCCW
    if SpeedCCW <= 0:
        MinTime = TimeCW
    else:
        MinTime = min(TimeCW, TimeCCW)

else:
    TimeCW = (L - S + D) / SpeedCW
    if SpeedCCW != 0:
        TimeCCW = (S - D) / SpeedCCW
    if SpeedCCW <= 0:
        MinTime = TimeCW
    else:
        MinTime = min(TimeCW, TimeCCW)

print(MinTime)