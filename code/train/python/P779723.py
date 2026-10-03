l = raw_input().split()
price = int(l[0])
set_price = int(l[1])
oranges = int(l[2])
set_num = int(l[3])

def main(price, set_price,oranges,set_num):
    sets = oranges / set_num
    amari = oranges % set_num
    result = price*amari + sets*set_price
    yobi = (sets+1)*set_price
    if(result > yobi):
        return yobi
    else:
        return result


print(main(price,set_price,oranges,set_num))
