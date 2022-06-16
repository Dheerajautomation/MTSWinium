Run('C:\Program Files\Max Secure Total Security\MaxSDUI.exe')
AutoItSetOption('MouseCoordMode',0)
WinWait("Max Secure Total Security")
WinActivate("Max Secure Total Security")
MouseClick("left",286,180,1,0)
Sleep(2000)
MouseClick("left",200,110,1,0)
Sleep(1000)
Send("123456")
Sleep(800)
MouseClick("left",208,157,1,0)
Sleep(2000)
MouseClick("left",73,253,1,0) ;Parental control click
MouseClick("left",74,253,1,0)
MouseClick("left",75,253,1,0)
Sleep(2000)
MouseClick("left",683,180,1,0);Open Setting
MouseClick("left",677,256,1,0);Open Internet block
Sleep(2000)
MouseClick("left",240,110,1,0);Uncheck Internet block
MouseClick("left",585,381,1,0);Click ok
Sleep(2000)
MouseClick("left",286,150,1,0);Click ok