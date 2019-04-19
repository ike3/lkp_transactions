@echo.

@rem ############################# WAS envitonment ########################################
@rem # In order to apply local parameters, just create setenv.bat file and set the data.  #

@set SERVERNODE=duzh-nbNode01
@set SERVERCELL=duzh-nbNode01Cell
@set SERVERNAME=server1

@set WAS_ROOT=C:\Program Files\IBM\WebSphere\AppServer\profiles\AppSrv01
@set ADMIN=-host localhost -port 8880 -lang jython -username admin -password admin

@if exist "setenv.bat" ( call setenv.bat )

@set CMD_OPTIONS=-verbose -node %SERVERNODE% -cell %SERVERCELL% -server %SERVERNAME% -usedefaultbindings -update 
@set APP_MANAGER=AdminControl.queryNames('type=ApplicationManager,node=%SERVERNODE%,process=%SERVERNAME%,*')

@set APP_EAR=lkp-transactions-callee-ear/target/lkp-transactions-callee.ear
@set APP_NAME=lkp-transactions-callee-ear
@call "%WAS_ROOT%\bin\wsadmin" %ADMIN%  -c "AdminApp.install('%APP_EAR%', '[%CMD_OPTIONS% -appname %APP_NAME%]')" -c "AdminConfig.save()"

@set APP_EAR=lkp-transactions-caller-ear/target/lkp-transactions-caller.ear
@set APP_NAME=lkp-transactions-caller-ear
@call "%WAS_ROOT%\bin\wsadmin" %ADMIN%  -c "AdminApp.install('%APP_EAR%', '[%CMD_OPTIONS% -appname %APP_NAME%]')" -c "AdminConfig.save()"
