package prosayj.thinking.spring._00_design_pattern.factory.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 面条
 *
 * @author yangjian
 */
public interface NoodlesService {
    Logger logger = LoggerFactory.getLogger(NoodlesService.class);

    /**
     * 描述每种面条的描述
     */
    void desc();
}
