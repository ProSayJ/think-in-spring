package prosayj.springiocannotation.transfer.service.impl;

import prosayj.springiocannotation.transfer.dao.AccountDao;
import prosayj.springiocannotation.transfer.pojo.Account;
import prosayj.springiocannotation.transfer.service.TransferService;

/**
 * TransferServiceImpl
 * <p>
 * private AccountDao accountDao = new JdbcAccountDaoImpl();
 * private AccountDao accountDao = (AccountDao) BeanFactory.getBean("accountDao");
 *
 * @author yangjian
 * @date 2021-05-13
 */
public class TransferServiceImpl implements TransferService {

    /**
     * AccountDao
     */
    private AccountDao accountDao;

    /**
     * 构造注入
     */
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
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
