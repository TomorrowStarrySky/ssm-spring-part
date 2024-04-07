package com.yuanzijun.ioc_01;

public class DefaultServiceLocator {
    private static ClientServiceImp1 clientService = new ClientServiceImp1();

    public ClientServiceImp1 createClientServiceInstance() {
        return clientService;
    }

}
