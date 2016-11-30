SET RESIN_HOME=E:\resin\resin-pro-3.1.8-with-r
SET PROJECT_PATH=%~dp0
%RESIN_HOME%\httpd.exe -conf %PROJECT_PATH%conf/resin-myvideo.xml

pause