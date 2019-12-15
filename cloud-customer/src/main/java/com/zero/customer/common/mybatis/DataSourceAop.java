package com.zero.customer.common.mybatis;import org.aspectj.lang.annotation.Aspect;import org.aspectj.lang.annotation.Before;import org.aspectj.lang.annotation.Pointcut;import org.slf4j.Logger;import org.slf4j.LoggerFactory;import org.springframework.stereotype.Component;/** * All rights Reserved, Designed By Suixingpay. * * @author: 张得钧<zhang_dj @ suixingpay.com> * @date: 2019-11-24 14:06 * @Copyright: 2019 Suixingpay. All rights reserved. * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。 */@Aspect@Componentpublic class DataSourceAop {    private static final Logger LOGGER = LoggerFactory.getLogger(DataSourceAop.class);    /*@Pointcut("!@annotation(com.zero.customer.annotation.Master) && " +            "(execution(* com.zero.customer.service..*.select*(..)) || " +            "execution(* com.zero.customer.service..*.get*(..)) || " +            "execution(* com.baomidou.mybatisplus.service..*.select*(..)) || " +            "execution(* com.zero.customer.service..*.find*(..)))")    public void readPointCut(){  }*/    @Pointcut("!@annotation(com.zero.customer.annotation.Master) && " +            "(execution(* com.zero.customer.mapper.master..*.select*(..)) || " +            "execution(* com.zero.customer.mapper.master..*.get*(..)) || " +            "execution(* com.baomidou.mybatisplus.mapper..*.select*(..)) || " +            "execution(* com.zero.customer.mapper..*.find*(..)))")    public void readMasterPointCut(){  }    @Pointcut("!@annotation(com.zero.customer.annotation.Master) && " +            "(execution(* com.zero.customer.mapper.slave..*.select*(..)) || " +            "execution(* com.zero.customer.mapper.slave..*.get*(..)) || " +            "execution(* com.baomidou.mybatisplus.mapper..*.select*(..)) || " +            "execution(* com.zero.customer.mapper..*.find*(..)))")    public void readSlavePointCut(){  }    @Pointcut("@annotation(com.zero.customer.annotation.Master) || execution(* com.zero.customer.mapper.master..*.insert*(..)) " +            "|| execution(* com.zero.customer.mapper.master..*.update*(..)) || execution(* com.baomidou.mybatisplus.mapper..*.update*(..)) " +            "|| execution(* com.zero.customer.mapper.master..*.delete*(..)) || execution(* com.baomidou.mybatisplus.mapper..*.delete*(..)) " +            "|| execution(* com.baomidou.mybatisplus.mapper..*.insert*(..))")    public void writeMasterPointcut() {    }    @Pointcut("@annotation(com.zero.customer.annotation.Master) || execution(* com.zero.customer.mapper.slave..*.insert*(..)) " +            "|| execution(* com.zero.customer.mapper.slave..*.update*(..)) || execution(* com.baomidou.mybatisplus.mapper..*.update*(..)) " +            "|| execution(* com.zero.customer.mapper.slave..*.delete*(..)) || execution(* com.baomidou.mybatisplus.mapper..*.delete*(..)) " +            "|| execution(* com.baomidou.mybatisplus.mapper..*.insert*(..))")    public void writeSlavePointcut() {    }    @Before("readMasterPointCut()")    public void readMaster(){        LOGGER.info("------switch read-------");        DbContextHolder.slave(0);    }    @Before("readSlavePointCut()")    public void readSlave(){        LOGGER.info("------switch read-------");        DbContextHolder.slave(1);    }    /*    * 主数据库进行修改操作    * */    @Before("writeMasterPointcut()")    public void writeMaster(){        LOGGER.info("------switch write-------");        DbContextHolder.master(0);    }    /*     * 从数据库进行修改操作     * */    @Before("writeSlavePointcut()")    public void writeSlave(){        LOGGER.info("------switch write-------");        DbContextHolder.master(1);    }}