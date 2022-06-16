Run('C:\Program Files\Max Secure Total Security\MaxSDUI.exe')
AutoItSetOption('MouseCoordMode',0)
WinWait("Max Secure Total Security")
WinActivate("Max Secure Total Security")
MouseClick("left",731,480,1,0)
Sleep(2000)
MouseClick("left",141,200,1,0)
Sleep(800)
MouseClick("left",200,110,1,0);Select Password
Sleep(1000)
Send("123456")
Sleep(800)
MouseClick("left",208,157,1,0);Enter Button
Sleep(1000)
MouseClick("left",214,122,1,0);Enter Button
Sleep(1000)
MouseClick("left",227,331,1,0);Click Remove Button
Sleep(2000)
MouseClick("left",282,270,1,0);Click Remove Button

