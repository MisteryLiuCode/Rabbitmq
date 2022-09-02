package com.liu.utils;

/**
 * All rights Reserved, Designed By jiexingcloud.
 *
 * @author 刘帅彪
 * @Date2022/9/2 15:11
 * Copyright ©2022 jiexingcloud. All rights reserved.
 * 注意：本内容仅限于结行云创内部传阅，禁止外泄以及用于其他的商业用途。
 */

public class ThreadSleep {

    public static void sleep(int time){
        try {
            Thread.sleep(1000*time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
