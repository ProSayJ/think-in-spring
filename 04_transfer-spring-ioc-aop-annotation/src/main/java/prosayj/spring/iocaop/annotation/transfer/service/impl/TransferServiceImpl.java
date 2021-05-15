package prosayj.spring.iocaop.annotation.transfer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
@Service("transferService")
public class TransferServiceImpl implements TransferService {
    /**
     * 最佳状态
     *
     * @Autowired 按照类型注入 ,如果按照类型无法唯一锁定对象，可以结合@Qualifier指定具体的id
     */
    @Autowired
    @Qualifier("accountDao")
    private AccountDao accountDao;


    @Override
    //@Transactional(rollbackFor = Exception.class)
    @Transactional
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
