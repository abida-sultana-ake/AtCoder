def get_max_score(s_list):
    score = 0
    for s in s_list:
        score += s

    if score % 10:
        return score

    max_score = score
    s_list = sorted(s_list)
    for s in s_list:
        if (max_score - s) % 10:
            score = max_score - s
            return score

    return 0

if __name__ == '__main__':
    N = int(input())
    s_list = []
    for i in range(N):
        s_list.append(int(input()))

    ans = get_max_score(s_list)
    print(ans)
