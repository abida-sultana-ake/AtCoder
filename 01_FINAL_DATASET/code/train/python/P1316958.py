def check1(H1, H2, W1, W2):
    S_min = 2 ** 50
    S_max = 0
    res1 = H1 * W1
    res2 = H1 * W2
    res3 = H2 * (W1 + W2)
    S_min = min(S_min, res1)
    S_min = min(S_min, res2)
    S_min = min(S_min, res3)
    S_max = max(S_max, res1)
    S_max = max(S_max, res2)
    S_max = max(S_max, res3)
    return S_max - S_min

def check2(H1, H2, W1, W2):
    S_min = 2 ** 50
    S_max = 0
    res1 = H1 * (W1 + W2)
    res2 = H2 * (W1)
    res3 = H2 * W2
    S_min = min(S_min, res1)
    S_min = min(S_min, res2)
    S_min = min(S_min, res3)
    S_max = max(S_max, res1)
    S_max = max(S_max, res2)
    S_max = max(S_max, res3)
    return S_max - S_min

def check3(H1, H2, W1, W2):
    S_min = 2 ** 50
    S_max = 0
    res1 = W1 * (H1 + H2)
    res2 = W2 * H1
    res3 = W2 * H2
    S_min = min(S_min, res1)
    S_min = min(S_min, res2)
    S_min = min(S_min, res3)
    S_max = max(S_max, res1)
    S_max = max(S_max, res2)
    S_max = max(S_max, res3)
    return S_max - S_min

def check4(H1, H2, W1, W2):
    S_min = 2 ** 50
    S_max = 0
    res1 = W2 * (H1 + H2)
    res2 = W1 * H1
    res3 = W1 * H2
    S_min = min(S_min, res1)
    S_min = min(S_min, res2)
    S_min = min(S_min, res3)
    S_max = max(S_max, res1)
    S_max = max(S_max, res2)
    S_max = max(S_max, res3)
    return S_max - S_min

def check_s(tmp1, tmp2, tmp3):
    S_min = 2 ** 50
    S_max = 0
    S_min = min(S_min, tmp1, tmp2, tmp3)
    S_max = max(S_max, tmp1, tmp2, tmp3)
    return S_max - S_min

if __name__ == "__main__":
    H,W = map(int, input().split())
    if (H > W):
        H,W = W,H
    if (H % 3 == 0 or W % 3 == 0):
        print (0)
        exit()
    if (H == 2 and W == 2):
        print (1)
        exit()
    H1 = H // 2
    H2 = H - H1
    W1 = W // 2
    W2 = W - W1
    result = 2 ** 50
    result = min(result, check1(H1, H2, W1, W2))
    result = min(result, check2(H1, H2, W1, W2))
    result = min(result, check3(H1, H2, W1, W2))
    result = min(result, check4(H1, H2, W1, W2))

    for x in range(1, W + 1):
        H1 = H // 2
        H2 = H - H1

        W1 = x
        W2 = W - W1

        W3 = W2 // 2
        W4 = W2 - W3

        tmp1 = W1 * H
        tmp2 = W3 * H
        tmp3 = W4 * H

        result = min(result, check_s(tmp1, tmp2, tmp3))
        tmp1 = W1 * H
        tmp2 = W2 * H1
        tmp3 = W2 * H2
        result = min(result, check_s(tmp1, tmp2, tmp3))

    for y in range(1,  H+ 1):
        H1 = y
        H2 = H - H1

        H3 = H2 // 2
        H4 = H3 - H2

        W1 = W // 2
        W2 = W - W1


        tmp1 = H1 * W
        tmp2 = H3 * W
        tmp3 = H4 * W

        result = min(result, check_s(tmp1, tmp2, tmp3))
        tmp1 = H1 * W
        tmp2 = H2 * W1
        tmp3 = H2 * W2
        result = min(result, check_s(tmp1, tmp2, tmp3))


    print (result)
