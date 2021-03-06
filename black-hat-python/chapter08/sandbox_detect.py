#!/usr/bin/env python
# -*- coding: utf-8 -*-

import ctypes
import random
import sys
import time

user32 = ctypes.windll.user32
kernel32 = ctypes.windll.kernel32

keystrokes = 0
mouse_clicks = 0
double_clicks = 0


class LASTINPUTINFO(ctypes.Structure):
    pass


LASTINPUTINFO._fields_ = [
    ("cbSize", ctypes.c_uint),
    ("dwTime", ctypes.c_ulong)
]


def get_last_input():
    struct_lastinputinfo = LASTINPUTINFO()
    struct_lastinputinfo.cbSize = ctypes.sizeof(LASTINPUTINFO)

    # 最後に行われた入力の情報を取得
    user32.GetLastInputInfo(ctypes.byref(struct_lastinputinfo))

    # パソコンが起動してからの時間を取得
    run_time = kernel32.GetTickCount()

    elapsed = run_time - struct_lastinputinfo.dwTime

    print("[*] It's been %d milliseconds since the last input event." % elapsed)

    return elapsed


def get_key_press():
    global mouse_clicks
    global keystrokes

    for i in range(0, 0xff):
        if user32.GetAsyncKeyState(i) == -32767:

            # 0x1 はマウスクリックを示す値
            if i == 0x1:
                mouse_clicks += 1
                return time.time()
            elif i > 32 and i < 127:
                keystrokes += 1

        return None


def detect_sandbox():
    global mouse_clicks
    global keystrokes
    global double_clicks

    max_keystrokes = random.randint(10, 25)
    max_mouse_clicks = random.randint(5, 25)
    max_double_clicks = 10

    double_clicks_threshold = 0.250  # 秒単位

    first_double_click = None

    max_inpute_threshold = 30000  # ミリ秒単位

    previous_timestamp = None
    detection_complete = False

    last_input = get_last_input()

    # しきい値に達した場合には、終了する
    if last_input >= max_inpute_threshold:
        sys.exit(0)

    while not detection_complete:

        keypress_time = get_key_press()

        if keypress_time is not None and previous_timestamp is not None:
            # クリックの間隔を算出
            elapsed = keypress_time - previous_timestamp

            # 利用者がダブルクリックした場合
            if elapsed <= double_clicks_threshold:
                double_clicks += 1

                if first_double_click is None:
                    # 最初のダブルクリックの日時を取得
                    first_double_click = time.time()

                else:

                    if double_clicks == max_double_clicks:
                        if keypress_time - first_double_click <= (max_double_clicks * double_clicks_threshold):
                            sys.exit(0)

            # 十分に利用者の入力を確認できた場合
            if keystrokes >= max_keystrokes and double_clicks >= max_double_clicks and mouse_clicks >= max_mouse_clicks:
                return

            previous_timestamp = keypress_time

        elif keypress_time is not None:
            previous_timestamp = keypress_time


detect_sandbox()
print("We are ok!")
