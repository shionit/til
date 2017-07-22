from gtts import gTTS
import os

tts = gTTS(text='Good morning.', lang='en')
tts.save("good.mp3")
os.system("open good.mp3")

