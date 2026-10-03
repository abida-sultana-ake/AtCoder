_N,_M=input().split()
N = int(_N)
M = int(_M)
l = []
for i in range(0,M):
    _p, _q = input().split()
    l.append((int(_p),int(_q)))
_A,_B=zip(*l)

A=_A+_B
B=_B+_A


def gen_get_to(_fr):
    global A
    global B
    global nodes
    global step
    for itr in range(0,len(A)):
        if A[itr]==_fr:
            if not B[itr] in nodes[0:step]:
                yield B[itr]

def move(): #returns whether "move" succeeded or not
    global nodes
    global possible_memo
    global step
    global counter
    global N
    global end_flag
    try:
        _=next(possible_memo[step])
        nodes[step+1]=_
        step+=1
        #print("success move to {}".format(nodes[step]))
        #print("map: {}".format(nodes[0:step+1]))
        #print("I am at {}th node".format(step+1))
        if step==N-1:
            counter+=1
            #print('REACHED GOAL!!!')
        possible_memo[step]=gen_get_to(nodes[step])
    except StopIteration:
        step-=1
        #print("failed to move")
        if not step==-1:
            pass#print("map: {}".format(nodes[0:step+1]))
            #print("I am at {}th node".format(step+1))
        if step==-1:
            #print("I fell from the first node")
            end_flag=True

nodes=[0]*N
possible_memo=[0]*N
counter=0
step=0
nodes[step]=1
possible_memo[step]=gen_get_to(nodes[0])
end_flag=False

while not end_flag:
    move()


print(counter)