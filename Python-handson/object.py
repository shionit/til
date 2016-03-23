# coding: UTF-8
# オブジェクト（変数と関数をまとめたもの）

# クラス：オブジェクトの設計図
# インスタンス：クラスを実体化したもの

# class define
class Person(object):
    def __init__(self, name):
        self.name = name

    def greet(self):
        print "my name is %s" % self.name

# class extend
class SuperPerson(Person):
    def shout(self):
        print "%s is SUPER!" % self.name

bob = Person("Bob")
tom = SuperPerson("Tom")

print bob.name
bob.greet()
tom.greet()
tom.shout()




