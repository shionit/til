# coding: UTF-8
# 関数とリスト(map) 無名関数

def double(x):
    return x * x

print(list(map(double, [1, 2, 5])))

# 無名関数
print(list(map(lambda x:x * x, [1, 2, 5])))
