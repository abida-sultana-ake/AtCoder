# -*- coding: utf-8 -*-
 
# 切り下げるメソッド
def roundDownTime(time_str):
    # 0～4は0に
    if 0 <= int(time_str[3:4]) <= 4:
        return time_str[0:3] + "0"
    # 5～9は5に
    if 5 <= int(time_str[3:4]) <= 9:
        return time_str[0:3] + "5"
 
# 切り上げるメソッド
def roundUpTime(time_str):
    # 0はそのまま
    if int(time_str[3:4]) == 0:
        return time_str
    # 1～5は5に
    if 1 <= int(time_str[3:4]) <= 5:
        return time_str[0:3] + "5"
    # 6～9は0に
    if 6 <= int(time_str[3:4]) <= 9:
        # 50分台だけは時のケタが動く
        if time_str[2:3] == "5":
            return str(int(time_str[0:2]) + 1) + "00"
        # 通常は10分のケタが動く
        else:
            return time_str[0:2] + str(int(time_str[2:3]) + 1) + "0"
 
# 入力の数値
counter = int(input())
input_list = [input() for _ in range(counter)]
 
# 開始時刻と終了時刻のペアで二次元リストを作る
time_list = [[0 for col in range(2)] for row in range(counter)]
i = 0
for input_str in input_list:
    # 丸め処理を完了させる
    time_list[i][0] = roundDownTime(input_str[0:4])
    time_list[i][1] = roundUpTime(input_str[5:9])
    i += 1
 
# 5分毎の時刻を格納する辞書
time_dict = {}
for i in range(0, 2401, 5):
    time_dict[i] = False
 
# 開始終了ペアの数でループ
for i in range(counter):
    start_time = int(time_list[i][0])
    end_time = int(time_list[i][1])
    # 開始時刻から終了時刻までの辞書の値をTrueにする
    for j in range(start_time, end_time, 5):
        time_dict[j] = True
 
# 辞書をキーでソート
sorted_dict = sorted(time_dict.items())
 
# フラグを使って開始終了の境界を判別する
isRain = False
for key, value in sorted_dict:
    if value is True and isRain is False:
        isRain = True
        # 桁埋めして文字列に戻す
        start_time = str("%04d" % key)
    if value is False and isRain is True:
        isRain = False
        end_time = str("%04d" % key)
        # 条件に当てはまった開始終了ペアを出力
        print(start_time + "-" + end_time)