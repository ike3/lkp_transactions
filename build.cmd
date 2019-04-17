@echo off
if exist "%FCS_HOME%\setenv.bat" ( call %FCS_HOME%\setenv.bat )

set params=package ^
    -Planit-repositories ^
    -T1C ^
    %2

set mode=%1
set pl=
if not $%mode%$==$noclean$ set params=clean %params%
if $%mode%$==$U$ set params=%params% -U

set mvn=%M2_HOME%\bin\mvn.cmd

if not $%pl%$==$$ call %mvn% %params% -pl %pl%
if $%pl%$==$$ call %mvn% %params%

xcopy /Q /F /Y lkp-transactions-callee-ear\target\lkp-transactions-callee.ear docker\callee\deployments_master
xcopy /Q /F /Y lkp-transactions-callee-ear\target\lkp-transactions-callee.ear docker\callee\deployments_slave
xcopy /Q /F /Y lkp-transactions-caller-ear\target\lkp-transactions-caller.ear docker\caller\deployments

if exist "%WF_PATH%\..\..\notifu64.exe" ( start %WF_PATH%\..\..\notifu64.exe /p "Job DONE" /m "LKP TRANSACTIONS %pl% build is finished!" )
