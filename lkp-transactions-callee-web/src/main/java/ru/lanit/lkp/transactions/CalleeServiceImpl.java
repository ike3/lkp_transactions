package ru.lanit.lkp.transactions;

import javax.jws.WebService;

@WebService(name = "CalleeService",
        serviceName = "CalleeService",
        endpointInterface = "ru.lanit.lkp.transactions.CalleeService",
        targetNamespace = "http://api.ws.transactions.lkp.lanit.ru/")
public class CalleeServiceImpl implements CalleeService {

    @Override
    public String doSomething(String parameter) {
        return "done";
    }

}
