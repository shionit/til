# coding: UTF-8
# ループ (for) / 辞書

sum = 0
for i in [1, 3, 5, 7, 11]:
    print i
    sum += i
else:
    print "total:" + str(sum)

for i in range(10):
    if i % 3 == 0:
        continue
    elif i == 8:
        break # breakはelseも飛ばしてしまう
    print i
else:
    print "end"

# dictionary
    
a = {"taguchi":200, "fkoji":300, "dotinstall":400}

for k, v in a.iteritems():
    print "key: %s value: %d" % (k, v)

for k in a.iterkeys():
    print k

for v in a.itervalues():
    print v
