package com.souche.myFuture;

/***
 *@author fanmiao
 *@date 2020/3/25 8:13 下午 
 */
public class RealData implements Data {
    private String result;

    public RealData(String data) {
        System.out.println("正在使用data:" + data + "网络请求数据,耗时操作需要等待.");
        try {
            Thread.sleep(3000);
        } catch (Exception e) {

        }
        System.out.println("操作完毕,获取结果...");
        result = "result";
    }

    @Override
    public String getRequest() {
        return result;
    }
}
