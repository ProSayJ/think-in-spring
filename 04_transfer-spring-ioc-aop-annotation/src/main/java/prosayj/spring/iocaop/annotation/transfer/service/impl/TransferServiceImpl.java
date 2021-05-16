package prosayj.spring.iocaop.annotation.transfer.service.impl;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import prosayj.spring.iocaop.annotation.transfer.dao.AccountDao;
import prosayj.spring.iocaop.annotation.transfer.pojo.Account;
import prosayj.spring.iocaop.annotation.transfer.service.TransferService;

/**
 * TransferServiceImpl
 * <p>
 * private AccountDao accountDao = new JdbcAccountDaoImpl();
 * private AccountDao accountDao = (AccountDao) BeanFactory.getBean("accountDao");
 *
 * @author yangjian
 * @date 2021-05-13
 */
@Data
@Service
@Transactional
public class TransferServiceImpl implements TransferService {
    @Autowired
    private AccountDao accountDao;

    public TransferServiceImpl() {
        System.out.println("TransferServiceImpl 实例化");
    }

    @Override
    public void transfer(String fromCardNo, String toCardNo, int money) throws Exception {


        Account from = accountDao.queryAccountByCardNo(fromCardNo);
        Account to = accountDao.queryAccountByCardNo(toCardNo);

        from.setMoney(from.getMoney() - money);
        to.setMoney(to.getMoney() + money);

        accountDao.updateAccountByCardNo(to);
        accountDao.updateAccountByCardNo(from);

    }
}
