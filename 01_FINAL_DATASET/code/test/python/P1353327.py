
def jifunTofun(jifun):
    ji = jifun[0:2]
    fun = jifun[2:4]
    output_fun = int(ji)*60+int(fun)
    return output_fun

class kanujikan:
    def __init__(self,given_startToEnd):
        startToEnd = given_startToEnd.split("-")
        self.startMinute = ((jifunTofun(startToEnd[0]))//5)*5
        self.endMinute = ((jifunTofun(startToEnd[1])+4)//5)*5
    def display_kanujikan(self):
        return "%02d"%(self.startMinute//60)+"%02d"%(self.startMinute%60)+"-"+"%02d"%(self.endMinute//60)+"%02d"%(self.endMinute%60)

def make_output(kanulist):
    kanulist.sort(key = lambda x:x.startMinute)
    tmp = kanulist.pop(0)
    output_kanulist = []
    for i in range(len(kanulist)):
        pop_tmp = kanulist.pop(0)
        if pop_tmp.startMinute <= tmp.endMinute:
            if pop_tmp.endMinute > tmp.endMinute:
                tmp.endMinute = pop_tmp.endMinute
        else:
            output_kanulist.append(tmp)
            tmp = pop_tmp

    output_kanulist.append(tmp)
    return output_kanulist


if __name__ == '__main__':
    num = (int)(input())

    given_kanulist = []

    for i in range(num):
        given_kanulist.append(kanujikan(input()))

    sortedKanulist = make_output(given_kanulist)

    for i in sortedKanulist:
        print(i.display_kanujikan())
