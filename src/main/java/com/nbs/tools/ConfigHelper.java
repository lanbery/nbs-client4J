package com.nbs.tools;

import UI.ConstantsUI;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Properties;

/**
 * @Package : com.nbs.tools
 * @Description :
 * <p>
 *     NBS配置类
 * </p>
 * @Author : lambor.c
 * @Date : 2018/6/19-8:35
 * Copyright (c) 2018, NBS , lambor.c<lanbery@gmail.com>.
 * All rights reserved.
 */
public class ConfigHelper {
    private static final Logger logger = LoggerFactory.getLogger(ConfigHelper.class);
    private static final String CONF_ROOT = ConstantsUI.CURRENT_DIR + File.separator+"config" + File.separator;
    private static final String CONF_FILE = "nbs-conf.properties";
    public static final String PK_SERVER_STATS = "ipfs.server.stats";
    public static final String PK_CFG_IPFS_ADDR = "nbs.server.address";
    private static final String IPFS_ADDR_DEFAULT = "/ip4/127.0.0.1/tcp/5001";



    private static Properties env = new Properties();
    static {
        InputStream is = null;
        try{
            is = new BufferedInputStream(new FileInputStream(
                    CnstTools.PROPS_ROOT_PATH + CONF_FILE));
            env.load(is);
            is.close();
        }catch (IOException ioe){
            logger.error("load config error.%s",ioe.getMessage());
            if(is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                }
            }
        }
    }

    /**
     *
     * @param key
     * @return
     */
    public static String getProperty(String key){
        if(key==null||"".equals(key.trim()))throw new IllegalArgumentException("key must a string");
        return env.getProperty(key);
    }

    /**
     *
     * @param key
     * @param value
     */
    public void setProperty(String key,String value){
        setProperty(key,value,null);
    }

    /**
     * 设置配置，并保存至config
     * @param key
     * @param value
     * @param comments
     */
    public static void setProperty(String key,String value ,String comments){
        if(StringUtils.isBlank(key))throw  new IllegalArgumentException("key must a string");
        boolean oldhas = env.containsKey(key);
        if(value==null)value = "";
        File configFile;
        FileOutputStream fos;
        try{
            env.setProperty(key,value);
            configFile = new File(CONF_ROOT + CONF_FILE);
            fos = new FileOutputStream(configFile);
            env.store(fos,comments);
        } catch (IOException e) {
            e.printStackTrace();
            if(!oldhas)env.remove(key);//如果不存在原始，则删除新的
            logger.error("NBS config File not find.",e.getMessage());
        }
    }

    /**
     * 移除
     * @param key
     */
    public static void removeProperty(String key){
        env.remove(key);
    }

    /**
     * 获取Server Address
     * @return
     */
    public static String getIpfsAddress(){
        String v = getProperty(PK_CFG_IPFS_ADDR);
        if(StringUtils.isBlank(v))v= IPFS_ADDR_DEFAULT;
        return v;
    }

    /**
     *
     * @return
     */
    public static Properties getEnv() {
        return env;
    }
}
