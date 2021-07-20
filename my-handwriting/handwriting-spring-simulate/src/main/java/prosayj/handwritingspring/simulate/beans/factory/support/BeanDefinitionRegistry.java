package prosayj.handwritingspring.simulate.beans.factory.support;

import prosayj.handwritingspring.simulate.beans.factory.config.BeanDefinition;
import prosayj.handwritingspring.simulate.beans.factory.expection.BeanDefinitionStoreException;
import prosayj.handwritingspring.simulate.beans.factory.expection.NoSuchBeanDefinitionException;
import prosayj.handwritingspring.simulate.core.AliasRegistry;

public interface BeanDefinitionRegistry extends AliasRegistry {


	void registerBeanDefinition(String beanName, BeanDefinition beanDefinition)  throws BeanDefinitionStoreException;


	void removeBeanDefinition(String beanName) throws NoSuchBeanDefinitionException;


	BeanDefinition getBeanDefinition(String beanName) throws NoSuchBeanDefinitionException;


	boolean containsBeanDefinition(String beanName);


	String[] getBeanDefinitionNames();


	int getBeanDefinitionCount();


	boolean isBeanNameInUse(String beanName);

}