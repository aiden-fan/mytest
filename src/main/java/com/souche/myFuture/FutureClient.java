package com.souche.myFuture;

/***
 *@author fanmiao
 *@date 2020/3/25 8:14 下午 
 */
public class FutureClient {
    public Data request(String queryStr) {
        FutureDate futureDate = new FutureDate();
        new Thread(new Runnable() {

            @Override
            public void run() {
                RealData realData = new RealData(queryStr);
                futureDate.setRealData(realData);
            }
        }).start();
        return futureDate;

    }
}
