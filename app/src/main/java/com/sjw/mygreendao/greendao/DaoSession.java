package com.sjw.mygreendao.greendao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.sjw.mygreendao.daobean.DayStep;
import com.sjw.mygreendao.daobean.User;

import com.sjw.mygreendao.greendao.DayStepDao;
import com.sjw.mygreendao.greendao.UserDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig dayStepDaoConfig;
    private final DaoConfig userDaoConfig;

    private final DayStepDao dayStepDao;
    private final UserDao userDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        dayStepDaoConfig = daoConfigMap.get(DayStepDao.class).clone();
        dayStepDaoConfig.initIdentityScope(type);

        userDaoConfig = daoConfigMap.get(UserDao.class).clone();
        userDaoConfig.initIdentityScope(type);

        dayStepDao = new DayStepDao(dayStepDaoConfig, this);
        userDao = new UserDao(userDaoConfig, this);

        registerDao(DayStep.class, dayStepDao);
        registerDao(User.class, userDao);
    }
    
    public void clear() {
        dayStepDaoConfig.clearIdentityScope();
        userDaoConfig.clearIdentityScope();
    }

    public DayStepDao getDayStepDao() {
        return dayStepDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

}
