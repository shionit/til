# coding: UTF-8
# 辞書　key value

a = {"taguchi":200, "yamada":300, "sasaki":500}

print(a)
print(a["yamada"])

a["yamada"] = 700

print(a)

# in
print("taguchi" in a)
print("takahashi" in a)

# keys, values, items

print(a.keys())
print(a.values())
print(a.items())
