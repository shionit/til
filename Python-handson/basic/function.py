# coding: UTF-8
# 関数
# 引数
# 返り値
# pass

def hello(name, num = 3):
    s = "hello! %s." % name * num
    print s
    return s

hello("Tom", 2)
hello("Steave")

s = hello(num = 2, name = "Tom")
print s

def hello2():
    pass # 何もしない

hello2()

