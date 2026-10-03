s = input()

alp = [chr(i) for i in range(97, 97+26)]

flag = [False for i in range(26)]

for c in s:
    flag[ord(c) - ord("a")] = True


def pr():
    for i in range(26):
        if not flag[i]:
            print(alp[i])
            return

    print('None')
    return

pr()
