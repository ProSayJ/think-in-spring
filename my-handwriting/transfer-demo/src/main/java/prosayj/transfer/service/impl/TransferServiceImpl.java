package prosayj.transfer.service.impl;


import prosayj.handwriting.spring.Autowired;
import prosayj.handwriting.spring.Component;
import prosayj.transfer.dao.AccountDao;
import prosayj.transfer.pojo.Account;
import prosayj.transfer.service.TransferService;
import prosayj.transfer.tx.TransactionManager;

/**
 * TransferServiceImpl
 * <p>
 * private AccountDao accountDao = new JdbcAccountDaoImpl();<br>
 * private AccountDao accountDao = (AccountDao) BeanFactory.getBean("accountDao");<br>
 *
 * @author yangjian
 * @date 2021-05-13
 */
@Component("transferService")
public class TransferServiceImpl implements TransferService {

    @Autowired
    private AccountDao accountDao;


    @Override
    public void transfer(String fromCardNo, String toCardNo, int money, boolean hasExpection) throws Exception {
        doTransfer(fromCardNo, toCardNo, money, hasExpection);
        //transferAroundTx(fromCardNo, toCardNo, money,hasExpection);
    }

    private void doTransfer(String fromCardNo, String toCardNo, int money, boolean hasExpection) throws Exception {
        System.out.println("转帐开始");
        Account from = accountDao.queryAccountByCardNo(fromCardNo);
        Account to = accountDao.queryAccountByCardNo(toCardNo);
        from.setMoney(from.getMoney() - money);
        to.setMoney(to.getMoney() + money);

        System.out.println("转帐开始-扣减 " + from.getName() + "【" + fromCardNo + "】 账户余额：" + money + " 元 开始");
        accountDao.updateAccountByCardNo(from);
        System.out.println("转帐开始-扣减 " + from.getName() + "【" + fromCardNo + "】 账户余额：" + money + " 元 结束。扣减完成");


        System.out.println("转帐开始-增加 " + to.getName() + "【" + toCardNo + "】 账户余额：" + money + " 元 开始");
        if (hasExpection) {
            System.out.println("转帐出现异常");
            throw new RuntimeException("触发业务异常");
        }
        accountDao.updateAccountByCardNo(to);
        System.out.println("转帐开始-增加 " + to.getName() + "【" + toCardNo + "】 账户余额：" + money + " 元 结束。增加完成");

        System.out.println("转帐结束");
    }

    /**
     * 手动执行事务
     */
//    private void transferAroundTx(String fromCardNo, String toCardNo, int money, boolean hasExpection) throws Exception {
//        // 开启事务(关闭事务的自动提交)
//        TransactionManager transactionManager = (TransactionManager) BeanFactory.getBean("transactionManager");
//        transactionManager.beginTransaction();
//        try {
//            doTransfer(fromCardNo, toCardNo, money, hasExpection);
//            // 提交事务
//            transactionManager.commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//            // 回滚事务
//            transactionManager.rollback();
//            // 抛出异常便于上层servlet捕获
//            throw e;
//        }
//    }
}
