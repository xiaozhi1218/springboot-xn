package com.mtl.common.tool.utils;

import java.util.Random;

/**
 * @author Exrickx
 */
public class IDUtil {

    /**
     * 随机id生成
     */
    public static String getRandomId() {
        long millis = System.currentTimeMillis();
        //加上两位随机数
        Random random = new Random();
        int end2 = random.nextInt(99);
        //如果不足两位前面补0
        String str = millis + String.format("%02d", end2);

        return str;
    }

}

