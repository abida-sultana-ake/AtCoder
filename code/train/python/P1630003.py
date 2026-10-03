if __name__ == '__main__':
    S = input()
    ans = ""
    n = len(S) - int(len(S)/2)
    for i in range(n):
        ans += S[2*i]
    print(ans)