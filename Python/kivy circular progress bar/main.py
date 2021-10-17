# "C:\py_venv\kivy_venv\scripts\activate"
from kivy.app import App
from kivy.uix.widget import Widget
from kivy.properties import ObjectProperty
from kivy.core.window import Window
from kivy.clock import Clock
from kivy.lang import Builder

# load kivy file
Builder.load_file('gui.kv')

# main class
class MainLayout(Widget):
    def circular_progress_slider(self, *args):
        value = int(args[1]) # return value

        # change the graphical value
        self.ids.circular_progress.my_progress = value
        
        # change the text
        self.ids.circular_progress.text = f'{int(value/3.6)}%'

class MyApp(App):
    def build(self):
        return MainLayout()

if __name__ == '__main__':
    MyApp().run()
