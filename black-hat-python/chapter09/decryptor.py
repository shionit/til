#!/usr/bin/env python
# -*- coding: utf-8 -*-

import zlib

import base64
from Crypto.Cipher import PKCS1_OAEP
from Crypto.PublicKey import RSA

# 秘密鍵をここにペースト
private_key = "###PASTE PRIVATE KEY HERE###"

rsakey = RSA.importKey(private_key)
rsakey = PKCS1_OAEP.new(rsakey)

chunk_size = 256
offset = 0
decrypted = ""
encrypted = base64.b64decode(encrypted)

while offset < len(encrypted):
    decrypted += rsakey.decrypt(encrypted[offset:offset + chunk_size])
    offset += chunk_size

# 解凍してオリジナルデータを手に入れる
plaintext = zlib.decompress(decrypted)

print(plaintext)
