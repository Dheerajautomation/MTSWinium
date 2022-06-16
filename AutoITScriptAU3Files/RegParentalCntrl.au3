Run('C:\Program Files\Max Secure Total Security\MaxSDUI.exe')
AutoItSetOption('MouseCoordMode',0)
WinWait("Max Secure Total Security")
WinActivate("Max Secure Total Security")
MouseClick("left",286,180,1,0)
Sleep(3000)
MouseClick("left",77,249,1,0)
Sleep(1000)
MouseClick("left",543,181,1,0)
Sleep(2000)
MouseClick("left",214,120,1,0) ;Parental control click
MouseClick("left",252,163,1,0);pass textbox
Send("123456")
MouseClick("left",233,201,1,0);confirm password
Send("123456")
MouseClick("left",244,277,1,0);Security Question
Send("Pune")
MouseClick("left",373,334,1,0);Save Button
Sleep(2000)
MouseClick("left",683,180,1,0);Open Setting


