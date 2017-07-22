# coding: UTF-8
# print

a = 10
b = "taguchi"
c = {"taguchi":100, "fkoji":200}

print "my age is %d" % a
print "my age is %5d" % a
print "my age is %05d" % a

print "my name is %s" % b

print "%s is %d years old" % (b, a)

print "%(taguchi)d" % c
