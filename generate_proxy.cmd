@echo off
if exist "setenv_was.bat" ( call setenv_was.bat )

set OUTPUT=C:\Users\skuzmin\Projects\fcs\eruz\lkp-transactions\lkp-transactions-common\src
set INPUT=file:/C:/Users/skuzmin/Projects/fcs/eruz/lkp-transactions/lkp-transactions-common/src/main/resources

mkdir %OUTPUT%\generated-sources
mkdir %OUTPUT%\generated-sources\wsclient
mkdir %OUTPUT%\classes
call %WAS_ROOT%\bin\wsimport.bat ^
    -target 2.0 -Xnocompile ^
    -s %OUTPUT%\generated-sources\wsclient -d %OUTPUT%\classes ^
    -p ru.lanit.lkp.transactions -wsdllocation /wsdl/CalleeService.wsdl "%INPUT%/wsdl/CalleeService.wsdl"

call %WAS_ROOT%\bin\wsimport.bat ^
    -target 2.0 -Xnocompile ^
    -s %OUTPUT%\generated-sources\wsclient -d %OUTPUT%\classes ^
    -p ru.lanit.lkp.transactions -wsdllocation /wsdl/CallerService.wsdl "%INPUT%/wsdl/CallerService.wsdl"