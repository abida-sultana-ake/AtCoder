#coding=UTF-8

# y/x 0 1 2 3
#   0 . . . .
#   1 . . . .
#   2 . . . .
#   3 . . . .
#

def tansaku(left,lst):
#    print(lst)
    if left == 0:
        return lst
    else:
        #find least y s.t. there in no quin
        for idy in range(0,8,1):
            if yoko[idy]==False:
                tgt_y=idy
                break

        for idx in range(0,8,1):
            if any([tate[idx],slash[idx+tgt_y],bkslash[idx-tgt_y+7]]):
                pass
            else:
                #place
                yoko[tgt_y]=True
                tate[idx]=True
                slash[idx+tgt_y]=True
                bkslash[idx-tgt_y+7]=True
                kaeshi=tansaku(left-1,lst+[(idx,tgt_y)])
                if kaeshi != None:
                    return kaeshi
                else:
                    #unplace
                    yoko[tgt_y]=False
                    tate[idx]=False
                    slash[idx+tgt_y]=False
                    bkslash[idx-tgt_y+7]=False

        return None


ban=[]
for idx in range(0,8,1):
    mozir=input()
    ban.append(mozir)

tate=[False]*8
yoko=[False]*8

slash=[False]*15
bkslash=[False]*15

brokenp=False

for idx in range(0,8,1):
    for idy in range(0,8,1):
        if ban[idy][idx]=='Q':
            if any([tate[idx],yoko[idy],slash[idx+idy],bkslash[idx-idy+7]]):
                brokenp=True
            else:
                tate[idx]=True
                yoko[idy]=True
                slash[idx+idy]=True
                bkslash[idx-idy+7]=True

if brokenp:
#    print('Broken')
    print('No Answer')
else:
    kaeshi=tansaku(8-3,[])
#    print('kaeshi:{}'.format(kaeshi))
    if kaeshi != None:
        for idy in range(0,8,1):
            demozi=''
            for idx in range(0,8,1):
                if ban[idy][idx]=='Q' or ((idx,idy) in kaeshi):
                    demozi+='Q'
                else:
                    demozi+='.'
            print(demozi)
    else:
        print('No Answer')
        
    
