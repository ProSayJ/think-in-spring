package prosayj.thinking.spring._02_inverseofcontroller;

import prosayj.thinking.spring._02_inverseofcontroller.UserDomain;

/**
 * 静态工厂
 *
 * @author yangjian
 * @date 2021-07-04 上午 08:42
 * @since 1.0.0
 */
class StaticUserDomianFactory {

    public static UserDomain getUserDomain() {
        return new UserDomain();
    }
}
