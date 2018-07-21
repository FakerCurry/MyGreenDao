package com.sjw.mygreendao.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.sjw.mygreendao.daobean.DayStep;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "DAY_STEP".
*/
public class DayStepDao extends AbstractDao<DayStep, Long> {

    public static final String TABLENAME = "DAY_STEP";

    /**
     * Properties of entity DayStep.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Date = new Property(1, String.class, "date", false, "DATE");
        public final static Property Step = new Property(2, int.class, "step", false, "STEP");
        public final static Property SportId = new Property(3, Long.class, "sportId", false, "SPORT_ID");
    }


    public DayStepDao(DaoConfig config) {
        super(config);
    }
    
    public DayStepDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"DAY_STEP\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"DATE\" TEXT," + // 1: date
                "\"STEP\" INTEGER NOT NULL ," + // 2: step
                "\"SPORT_ID\" INTEGER);"); // 3: sportId
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"DAY_STEP\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, DayStep entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String date = entity.getDate();
        if (date != null) {
            stmt.bindString(2, date);
        }
        stmt.bindLong(3, entity.getStep());
 
        Long sportId = entity.getSportId();
        if (sportId != null) {
            stmt.bindLong(4, sportId);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, DayStep entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String date = entity.getDate();
        if (date != null) {
            stmt.bindString(2, date);
        }
        stmt.bindLong(3, entity.getStep());
 
        Long sportId = entity.getSportId();
        if (sportId != null) {
            stmt.bindLong(4, sportId);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public DayStep readEntity(Cursor cursor, int offset) {
        DayStep entity = new DayStep( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // date
            cursor.getInt(offset + 2), // step
            cursor.isNull(offset + 3) ? null : cursor.getLong(offset + 3) // sportId
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, DayStep entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setDate(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setStep(cursor.getInt(offset + 2));
        entity.setSportId(cursor.isNull(offset + 3) ? null : cursor.getLong(offset + 3));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(DayStep entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(DayStep entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(DayStep entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
