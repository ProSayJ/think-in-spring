package prosayj.thinking.spring._04_bean_lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.stereotype.Component;

import java.beans.PropertyDescriptor;

@Component
 public class SpringBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {
 
     @Override
     public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
         if ("lifeCycleDomin2".equals(beanName)) {
             System.out.println(">>>> postProcessBeforeInstantiation");
         }
         return super.postProcessBeforeInstantiation(beanClass, beanName);
     }
 
     @Override
     public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
         if ("lifeCycleDomin2".equals(beanName)) {
             System.out.println(">>>> postProcessAfterInstantiation");
         }
         return super.postProcessAfterInstantiation(bean, beanName);
     }
 
     @Override
     public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
         if ("lifeCycleDomin2".equals(beanName)) {
             System.out.println(">>>> postProcessPropertyValues");
         }
         return super.postProcessPropertyValues(pvs, pds, bean, beanName);
     }
 
     @Override
     public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
         if ("lifeCycleDomin2".equals(beanName)) {
             System.out.println(">>>> postProcessBeforeInitialization");
         }
         return super.postProcessBeforeInitialization(bean, beanName);
     }
 
     @Override
     public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
         if ("lifeCycleDomin2".equals(beanName)) {
             System.out.println(">>>> postProcessAfterInitialization");
         }
         return super.postProcessAfterInitialization(bean, beanName);
     }
 }