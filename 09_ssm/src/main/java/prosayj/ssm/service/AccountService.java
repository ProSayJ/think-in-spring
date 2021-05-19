package prosayj.ssm.service;

import prosayj.ssm.pojo.Account;

import java.util.List;

public interface AccountService {
    List<Account> queryAccountList() throws Exception;
}
