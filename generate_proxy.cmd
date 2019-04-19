@echo off
if exist "setenv.bat" ( call setenv.bat )

set INPUT=C:\Users\skuzmin\Projects\fcs\eruz\lkp-transactions\lkp-transactions-common\target
set OUTPUT=file:/C:/Users/skuzmin/Projects/fcs/eruz/lkp-transactions/lkp-transactions-common/src/main/resources

call %WAS_ROOT%\bin\wsimport.bat ^
    -target 2.0 -Xnocompile ^
    -s %INPUT%\generated-sources\wsclient -d %INPUT%\classes ^
    -p ru.lanit.lkp.transactions -wsdllocation /wsdl/CalleeService.wsdl "%OUTPUT%/wsdl/CalleeService.wsdl"

call %WAS_ROOT%\bin\wsimport.bat ^
    -target 2.0 -Xnocompile ^
    -s %INPUT%\generated-sources\wsclient -d %INPUT%\classes ^
    -p ru.lanit.lkp.transactions -wsdllocation /wsdl/CallerService.wsdl "%OUTPUT%/wsdl/CallerService.wsdl"