package prosayj.spring.transfer.service;

/**
 * TransferService
 *
 * @author yangjian
 * @date 2021-05-13
 */
public interface TransferService {

    /**
     * 转帐
     *
     * @param fromCardNo fromCardNo
     * @param toCardNo   toCardNo
     * @param money      money
     * @throws Exception Exception
     */
    void transfer(String fromCardNo, String toCardNo, int money) throws Exception;
}
