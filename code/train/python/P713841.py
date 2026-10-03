#!/usr/bin/env python3

import array
import math


MAX_B = 2 * 10 ** 4 + 1


class CumulativeSum(object):  # 累積和

    def __init__(self, sequence, typecode="Q"):
        self.cumulative_sum = array.array(typecode)
        self.cumulative_sum.append(0)
        for element in sequence:
            self.cumulative_sum.append(self.cumulative_sum[-1] + element)

    def partial_sum(self, first, last):
        # 第first要素から第last要素（両端を含む）までの部分和を求める
        return self.cumulative_sum[last + 1] - self.cumulative_sum[first]


class Cone(object):  # 円錐

    def __init__(self, x_bottom, radius, height):
        # 円錐の底面のx座標
        self.x_bottom = x_bottom
        # 円錐の底面の半径
        self.radius = radius
        # 円錐の高さ
        self.height = height
        # 円錐の頂点のx座標
        self.x_top = x_bottom + height
        # tanΘ
        self.tan_theta = radius / height

    def frustum_volume(self, lower, upper):
        if self.x_bottom >= upper or self.x_top <= lower:
            # 円錐がまるっきり区間外にあれば体積は0
            return 0.0
        # 円錐台の上底面のx座標
        x_upper_bottom = min(self.x_top, upper)
        # 円錐台の下底面のx座標
        x_lower_bottom = max(self.x_bottom, lower)
        # 円錐台の上底面の半径
        r_u = (self.x_top - x_upper_bottom) * self.tan_theta
        # 円錐台の下底面の半径
        r_l = (self.x_top - x_lower_bottom) * self.tan_theta
        # 円錐台の体積
        v = math.pi * (r_l * r_l + r_l * r_u + r_u * r_u) / 3.0
        return v


def main():
    n, q = map(int, input().split())
    cones = [Cone(*map(int, input().split())) for _ in range(n)]
    # [x, x + 1]に含まれる部分の体積をvs[x]とする
    vs = array.array("d", (sum(cone.frustum_volume(x, x + 1)
                               for cone in cones) for x in range(MAX_B)))
    cs = CumulativeSum(vs, "d")
    for _ in range(q):
        a, b = map(int, input().split())
        print("{:.6f}".format(cs.partial_sum(a, b - 1)))


if __name__ == '__main__':
    main()
