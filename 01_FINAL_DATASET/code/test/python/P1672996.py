import operator
"""
seqをstep個で尺取するfuncは区間に要素を足すときの演算，区間から小さいほうの要素を外すときの演算
"""

def constantstep_syakutori(seq,step,func,invfunc):
    if len(seq)<step:
        return None
    else:
        returned=[]
        firststep=seq[0]
        for i in range(1,step):
            firststep=func(firststep,seq[i])
        returned.append(firststep)
        for i in range(len(seq)-step):
            firststep=func(firststep,seq[step+i])
            firststep=invfunc(firststep,seq[i])
            returned.append(firststep)
        return returned
n, k = list(map(int, input().split()))
a = list(map(int, input().split()))

print(sum(constantstep_syakutori(a,k,operator.add,operator.sub)))
            