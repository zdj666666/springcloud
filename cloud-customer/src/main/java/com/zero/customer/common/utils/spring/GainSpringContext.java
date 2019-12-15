package com.zero.customer.common.utils.spring;import org.springframework.beans.BeansException;import org.springframework.context.ApplicationContext;import org.springframework.context.ApplicationContextAware;import org.springframework.stereotype.Component;/** * All rights Reserved, Designed By Suixingpay. * * @author: 张得钧<zhang_dj @ suixingpay.com> * @date: 2019-11-26 13:54 * @Copyright: 2019 Suixingpay. All rights reserved. * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。 */@Componentpublic class GainSpringContext implements ApplicationContextAware {    private static ApplicationContext applicationContext;    @Override    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {        //引用类下面的全局变量使用this.形式，避免与方法里的参数重复        this.applicationContext = applicationContext;    }    public static Object getBean(String beanName) throws BeansException {       /* char[] cs = beanName.toCharArray();        cs[0] += 32;        beanName = String.valueOf(cs);*/        //传入带参数的获取bean对象名        return applicationContext.getBean(beanName);    }}