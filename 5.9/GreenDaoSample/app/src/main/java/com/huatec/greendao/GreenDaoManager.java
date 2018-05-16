package com.huatec.greendao;

import com.huatec.greendao.gen.DaoMaster;
import com.huatec.greendao.gen.DaoSession;

/**
 * Created by zhusheng on 2018/5/12.
 */

public class GreenDaoManager {
    private static GreenDaoManager mInstance;
    private DaoMaster daoMaster;    //它以一定的模式来管理我们Dao类中的数据库对象,并创建DaoSession
    private DaoSession daoSession;//负责创建和管理Dao

    public GreenDaoManager(){

        if(mInstance == null){
           DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(MyApplication.getContext(),"mydb");
            daoMaster = new DaoMaster(devOpenHelper.getWritableDb());
            daoSession = daoMaster.newSession();
        }
    }

    public static GreenDaoManager getInstance(){
        if(mInstance == null){
            synchronized (GreenDaoManager.class){
                if(mInstance == null){
                    mInstance = new GreenDaoManager();
                }
            }
        }
        return mInstance;
    }

    public DaoMaster getDaoMaster() {
        return daoMaster;
    }

    public void setDaoMaster(DaoMaster daoMaster) {
        this.daoMaster = daoMaster;
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

    public void setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
    }
}
