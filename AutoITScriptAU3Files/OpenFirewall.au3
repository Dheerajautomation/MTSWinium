Run('C:\Program Files\Max Secure Total Security\MaxSDUI.exe')
AutoItSetOption('MouseCoordMode',0)
WinWait("Max Secure Total Security")
WinActivate("Max Secure Total Security")
MouseClick("left",286,180,1,0)
Sleep(2000)
MouseClick("left",200,110,1,0)
Sleep(1000)
Send("123456")
MouseClick("left",208,157,1,0)
Sleep(2000)
MouseClick("left",73,253,1,0) ;Parental control click
Sleep(2000)
MouseClick("left",683,180,1,0);Open Setting


