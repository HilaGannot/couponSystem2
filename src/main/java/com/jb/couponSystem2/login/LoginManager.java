package com.jb.couponSystem2.login;

import com.jb.couponSystem2.exaption.CouponsSystemException;
import com.jb.couponSystem2.service.AdminServiceImpl;
import com.jb.couponSystem2.service.ClientService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/*

Hila Gannot
11/20/2022 2:32

*/
@Component
public class LoginManager {

    @Autowired
    AdminServiceImpl adminService;

    public ClientService login(String email, String password, ClientType clientType) throws CouponsSystemException {
        ClientService clientService = null;
        switch (clientType) {
            case Administartor:
                clientService = adminService;
                if (clientService.login(email, password)) {
                    return clientService;
                }
                break;

//            case Company:
//                clientService = new CompanyServiceImpl();
//                if (clientService.login(email, password)) {
//                    return clientService;
//                }
//                break;
//
//            case Customer:
//                clientService = new CustomerServiceImp();
//                if (clientService.login(email, password)) {
//                    return clientService;
//                }
//                break;
        }
        return null;
    }
}
