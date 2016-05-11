#!/usr/bin/env python
# -*- coding: utf-8 -*-

import urllib2

body = urllib2.urlopen("http://www.google.com")

print body.read()

