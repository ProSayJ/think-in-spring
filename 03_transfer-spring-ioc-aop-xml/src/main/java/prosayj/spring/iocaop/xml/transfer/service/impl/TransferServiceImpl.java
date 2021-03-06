package prosayj.spring.iocaop.xml.transfer.service.impl;

import lombok.Data;
import prosayj.spring.iocaop.xml.transfer.dao.AccountDao;
import prosayj.spring.iocaop.xml.transfer.pojo.Account;
import prosayj.spring.iocaop.xml.transfer.service.TransferService;

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
public class TransferServiceImpl implements TransferService {
    private AccountDao accountDao;

    public TransferServiceImpl() {
        System.out.println("TransferServiceImpl 实例化");
    }

    @Override
    public void transfer(String fromCardNo, String toCardNo, int money) throws Exception {

        /*try{
            // 开启事务(关闭事务的自动提交)
            TransactionManager.getInstance().beginTransaction();*/

        Account from = accountDao.queryAccountByCardNo(fromCardNo);
        Account to = accountDao.queryAccountByCardNo(toCardNo);

        from.setMoney(from.getMoney() - money);
        to.setMoney(to.getMoney() + money);

        accountDao.updateAccountByCardNo(to);
        accountDao.updateAccountByCardNo(from);

        /*    // 提交事务

            TransactionManager.getInstance().commit();
        }catch (Exception e) {
            e.printStackTrace();
            // 回滚事务
            TransactionManager.getInstance().rollback();

            // 抛出异常便于上层servlet捕获
            throw e;

        }*/


    }
}
