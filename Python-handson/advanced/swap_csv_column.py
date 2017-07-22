# -*- coding: utf-8 -*-

import sys
import os
import csv


if __name__ != '__main__':
    quit()

argvs = sys.argv  # コマンドライン引数を格納したリストの取得
argc = len(argvs) # 引数の個数

if (argc != 2):   # 引数が足りない場合は、その旨を表示
    print 'Usage: # python %s filename' % argvs[0]
    quit()         # プログラムの終了

infilepath = argvs[1]

if (os.path.exists(infilepath) != True):
    print 'File not found %s' % infilepath
    quit()

outfilename = "ColumnChanged.tsv"
outfiledir = os.path.dirname(infilepath)
# 出力ファイルは入力ファイルと同一の場所に
outfilepath = os.path.join(outfiledir, outfilename)
writecsv = csv.writer(file(outfilepath, 'w'), delimiter='\t') # 書き込みファイルの設定

with open(infilepath, 'rb') as tsvfile:
    contents = csv.reader(tsvfile, delimiter='\t')

    for rows in contents:
        lines = []
        lines.append(rows[-1])
        for remain in rows[0:-1]:
            lines.append(remain)

        writecsv.writerow(lines)
