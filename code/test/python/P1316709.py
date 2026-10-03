# coding: utf-8
def get_ln_inputs():
    return input().split()


def get_ln_int_inputs():
    return list(map(int, get_ln_inputs()))


INTERVAL_TIME = 5


class Time:
    def __init__(self, hour, minute):
        self.hour = hour
        self.minute = minute


    def fast_forward(self, minutes):
        new_minute = self.minute + minutes
        new_hour = self.hour + (new_minute // 60)
        return Time(new_hour, new_minute % 60)

    
    def get_prev_interval(self):
        rewind_mins = self.minute % 5
        return Time(self.hour, self.minute - rewind_mins)


    def get_next_interval(self):
        ff_mins = -(self.minute % (-5))
        return self.fast_forward(ff_mins)


    def later_than(self, time):
        if self.hour > time.hour:
            return True
        if self.hour == time.hour and self.minute > time.minute:
            return True
        return False


    def earlier_than(self, time):
        if self.hour < time.hour:
            return True
        if self.hour == time.hour and self.minute < time.minute:
            return True
        return False


    def clone(self):
        return Time(self.hour, self.minute)


    def get_plain(self):
        return ("%02d" % self.hour) + ("%02d" % self.minute)


    def equals(self, time):
        return self.hour == time.hour and self.minute == time.minute


    def total_minute(self):
        return self.hour * 60 + self.minute


class TimeSpan:
    def __init__(self, startTime, endTime):
        self.start = startTime.get_prev_interval()
        self.end = endTime.get_next_interval()


    def includes(self, time):
        return (time.later_than(self.start) or time.equals(self.start)) and \
        time.earlier_than(self.end)


    def overlaps(self, time_span):
        if self.start.later_than(time_span.start):
            return time_span.overlaps(self)
        return self.end.later_than(time_span.start) or self.end.equals(time_span.start)


    def get_plain(self):
        return self.start.get_plain() + "-" + self.end.get_plain()


def get_span(span_string):
    start_hour = int(span_string[:2])
    start_mins = int(span_string[2:4])
    end_hour = int(span_string[5:7])
    end_mins = int(span_string[7:9])
    return TimeSpan(Time(start_hour, start_mins), Time(end_hour, end_mins))


def merge(time_span_1, time_span_2):
    if time_span_1.start.later_than(time_span_2.start):
        return merge(time_span_2, time_span_1)
    endTime = max(time_span_1.end, time_span_2.end, key=lambda time: time.total_minute())
    return TimeSpan(time_span_1.start, endTime)


def main():
    rain_memo = list()
    N = get_ln_int_inputs()[0]

    for _ in range(N):
        rain_memo.append(get_span(get_ln_inputs()[0]))
    
    time = Time(0, 0)
    end_time = Time(24, 0)
    span_records = sorted(rain_memo, key=lambda span: span.start.total_minute())
    
    index = 0
    while index < len(span_records) - 1:
        record = span_records[index]
        record_next = span_records[index + 1]
        if record.overlaps(record_next):
            merged_span = merge(record, record_next)
            span_records.pop(index)
            span_records.pop(index)
            span_records.insert(index, merged_span)
        else:
            index += 1

    for span in span_records:
        print(span.get_plain())


main()