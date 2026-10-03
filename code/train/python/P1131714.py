def input_parser():
    N=int(input())
    s=input()
    return N, s
N, s=input_parser()
s_bool=[_s is 'o' for _s in s]
ans=-1
for flag in range(0,4):
    if flag==0:
        animals=[True,True]
    elif flag==1:
        animals = [True, False]
    elif flag==2:
        animals=[False,True]
    else:
        animals=[False,False]
    for animal_index in range(1,N-1,1):
        animals.append((animals[animal_index] is animals[animal_index-1])is s_bool[animal_index])

    def last_check(s_bool,animals):
        global N
        # first animal witness
        if (((animals[N-2]==animals[0]) is s_bool[N-1]) is animals[N-1]) and ((((animals[N-1]==animals[1]) is s_bool[0]))is animals[0]):
            return True
        else:
            return False
    if last_check(s_bool,animals):
        ans=""
        for itr in range(0,N,1):
            if animals[itr]:
                ans += 'S'
            else:
                ans += 'W'
        break

def output_parser(output):
    print(output)

output_parser(ans)