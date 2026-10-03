N = int(input())
s = input()

s_flag = [1 if s[i]=='o' else -1 for i in range(N)]

def find_pattern(init_t_flag):
    for i in range(2, len(s_flag)):
        init_t_flag.append(init_t_flag[i-2]*init_t_flag[i-1]*s_flag[i-1])
    first_t_flag = init_t_flag[-2] * init_t_flag[-1] * s_flag[-1]
    second_t_flag = init_t_flag[-1] * init_t_flag[0] * s_flag[0]
    if init_t_flag[0] == first_t_flag and init_t_flag[1] == second_t_flag:
        return init_t_flag
    else:
        return -1

def output_result():
    res_SS = find_pattern([1,1])
    if res_SS != -1:
        res = ['S' if res_SS[i]==1 else 'W' for i in range(N)]
        return("".join(res))

    res_SW = find_pattern([1, -1])
    if res_SW != -1:
        res = ['S' if res_SW[i]==1 else 'W' for i in range(N)]
        return("".join(res))

    res_WS = find_pattern([-1,1])
    if res_WS != -1:
        res = ['S' if res_WS[i]==1 else 'W' for i in range(N)]
        return("".join(res))

    res_WW = find_pattern([-1, -1])
    if res_WW != -1:
        res = ['S' if res_WW[i]==1 else 'W' for i in range(N)]
        return("".join(res))

    return(-1)

print(output_result())