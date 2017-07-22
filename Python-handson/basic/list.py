# coding: UTF-8
# リスト

a = [1, 2, "a", 5.5]
b = list([3, 5])

print a
print b

# len + * [] [start:end]

print len(a)

print a + b

print a * 5

print a[2]

a[2] = "b"

print a

a[2:4] = ["b", "c"]

print a

# sort / reverse

a = [1, 5, 2, 10, 8]

a.sort()
print a
a.reverse()
print a

# in 存在チェック

print 3 in a
print 5 in a

#range

b = range(10)
print b
print range(3, 10)
print range(3, 10, 2)

# リストと文字列の相互変換
# split join

s = "2012/10/12"
a = s.split("/")

print a

ss = ["a", "b", "c"]
all = "-".join(ss)

print all
