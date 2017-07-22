# coding: UTF-8
# 関数とリスト(map) 無名関数

def double(x):
    return x * x

print map(double, [1, 2, 5])

# 無名関数
print map(lambda x:x * x, [1, 2, 5])
