/**
 * All rights Reserved, Designed By Suixingpay.
 *
 * @author: 张得钧<zhang_dj @ suixingpay.com>
 * @date: 2018/12/18 15:40
 * @Copyright: 2018 Suixingpay. All rights reserved.
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package com.zero.customer.config.property;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @description:获取配置信息中的属性
 * @author: 张得钧[zhang_dj@suixingpay.com]
 * @date: 2018/12/18 15:40
 * @version: V1.0
 */
@Slf4j
public class GainPropertyData {

    public static final String path = "/application.yml";

    public static String getData(String propKey) {
        InputStream url = GainPropertyData.class
                .getResourceAsStream(path);
        Properties prop = new Properties();
        InputStream is = null;
        String str = "";
        try {
            is = url;
            prop.load(is);
            str = (String) prop.get(propKey);
        } catch (Exception e) {
        log.info("打印异常日志信息是:[{}]",e);
        } finally {
            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    log.info("系统异常", e);
                }
            }
        }
        return null == str ? "" : str;
    }


}
