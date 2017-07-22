# coding: UTF-8
# 文字列
# " '
# escape \n \t \\
# """ '''
# u"こんにちは"

print 'hello'

print 'it\'s a pen.'

print "This is mine. \n\t and it\'s yours. \\"

print """
<html>
<body>
</body>
</html>"""

print "日本語出力"

print u"日本語出力"

# 文字列の操作

# 連結 +

print "hello" + "world"

# 繰り返し *

print u"無駄！" * 10

# 長さ len
print len("abcdefg")

s = "abcdefghi"

# 切り出し [] [start:end]

print s[1]

print s[1:5]
print s[:5]
print s[3:]
print s[1:-1]

# 検索 find

print s.find("cd")

print s.find("cx")
