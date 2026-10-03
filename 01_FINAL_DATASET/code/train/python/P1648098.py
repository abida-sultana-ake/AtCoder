#!/usr/bin/env python3
# -*- coding: utf-8 -*-

MAP = {
    "Sunday"    : 0,
    "Monday"    : 5,
    "Tuesday"   : 4,
    "Wednesday" : 3,
    "Thursday"  : 2,
    "Friday"    : 1,
    "Saturday"  : 0,
}

def main():
    S = input()
    print(MAP[S])

if __name__ == "__main__": main()
