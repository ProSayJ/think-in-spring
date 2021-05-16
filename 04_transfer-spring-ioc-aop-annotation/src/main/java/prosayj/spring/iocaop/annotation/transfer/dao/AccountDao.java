package prosayj.spring.iocaop.annotation.transfer.dao;


import prosayj.spring.iocaop.annotation.transfer.pojo.Account;

/**
 * AccountDao
 *
 * @author yangjian
 * @date 2021-05-13
 */
public interface AccountDao {

    /**
     * 通过cardNo查询账户
     *
     * @param cardNo cardNo
     * @return cardNo
     * @throws Exception Exception
     */
    Account queryAccountByCardNo(String cardNo) throws Exception;

    /**
     * 通过cardNo更新账户
     *
     * @param account account
     * @return int
     * @throws Exception Exception
     */
    int updateAccountByCardNo(Account account) throws Exception;
}
