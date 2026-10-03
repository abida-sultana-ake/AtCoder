if __name__ == "__main__":
    inp = [int(i) for i in input().split()]
    K = inp[0]
    S = inp[1]
    c = 0
    for x in range(K+1):
        for y in range(K+1):
            z = S - x - y
            if z >= 0 and z <= K:
                c += 1
    print(c)