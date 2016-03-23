#!/usr/bin/env python
# -*- coding: utf-8 -*-

import socket

# for internet server
#target_host = "www.google.com"
#target_port = 80
# for local server
target_host = "0.0.0.0"
target_port = 9999

# create socket object
client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

# connect server
client.connect((target_host, target_port))

# send data
client.send("GET / HTTP/1.1\r\nHost: google.com\r\n\r\n")

# receive data
response = client.recv(4096)

print response
