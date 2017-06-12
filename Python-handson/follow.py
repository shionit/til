#!/usr/bin/env python
# -*- coding: utf-8 -*-

# Watch a log file (stocks in this case)

import os
import time

def follow(filename):
    print(filename)
    f = open(filename, 'r')
    f.seek(0, os.SEEK_END)

    while True:
        line = f.readline()
        if not line:
            time.sleep(0.1)
            continue    # Retry

        yield line      # Emit a line

for line in follow('Data/someoneslog.csv'):
    row = line.split(' ')
    change = row[-1]
    if change:
        year = row[0]
        month = row[1]
        print('{:>5s} {:>5s} {:>10s}', year, month, change)
