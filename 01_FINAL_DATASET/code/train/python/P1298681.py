# -*- coding:utf-8 -*-
h,w = map(int,input().split())
if w % 3 == 0 or h % 3 == 0:
    print(0)
else:
    arr = []
    smax = (h // 3 + 1) * w
    smin = (h - (h//3 + 1)) * (w//2)
    arr.append(smax - smin)
    smax = (w//3 + 1) * h
    smin = (w - (w//3 + 1)) * (h//2)
    arr.append(smax - smin)
    
    smin = (h//3) * w
    if smax != 0:
        if w % 2 == 1:
            smax = (h - (h//3)) * (w//2 + 1)
        else:
            smax = (h - (h//3)) * (w//2)
        arr.append(smax - smin)
    #print(smax,smin)
    
    smin = (w//3) * h
    if smax != 0:
        if h % 2 == 1:
            smax = (w - (w//3)) * (h//2 + 1)
        else:
            smax = (w - (w//3)) * (h//2)
        arr.append(smax - smin)
    #print(smax,smin)
        
    smax = (h//3 + 1) * w
    smin = (h//3) * w
    arr.append(smax - smin)
    smax = (w//3 + 1) * h
    smin = (w//3) * h
    arr.append(smax - smin)    
    print(min(arr))
    #print(arr)
