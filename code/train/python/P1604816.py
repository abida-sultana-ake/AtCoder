def C_Sphinx(N, M):
    adult = 0  # 大人の人数
    aged = 0  # 老人の人数
    baby = 0  # 赤ちゃんの人数

    if M % 2 != 0:
        # もし足の数が奇数なら、老人の人数を1とする
        # (解の候補の1つだけ出せばよいので、1人でよい)
        aged = 1
    # 老人の数は決定できたので、連立方程式を解く
    # 大人+老人+赤ちゃん=N,大人*2+老人*3+赤ちゃん*4=M
    tmp = (M - aged - 2 * N) // 2
    adult = N - tmp - aged
    baby = tmp

    if adult < 0 or baby < 0:
        return '-1 -1 -1'
    else:
        return '{} {} {}'.format(adult, aged, baby)

N,M=[int(i) for i in input().split()]
print(C_Sphinx(N, M))