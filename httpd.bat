SET RESIN_HOME=J:\resin-pro-3.1.8
SET PROJECT_PATH=%~dp0
%RESIN_HOME%\httpd.exe -conf %PROJECT_PATH%conf/resin-myvideo.xml

pause