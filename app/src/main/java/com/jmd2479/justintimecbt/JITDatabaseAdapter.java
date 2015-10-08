package com.jmd2479.justintimecbt;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Jonathan on 9/16/2015.
 */
public class JITDatabaseAdapter  {

    JITDatabaseHelper helper;

    public JITDatabaseAdapter(Context context){
        helper = new JITDatabaseHelper(context);
        Log.d("DBStuff", "JITDatabaseAdapter constructor");
    }

    //Behavior-related SQL statements
    public long insertBehavior(String name){
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(helper.BEHAVIOR_NAME, name);
        long id = db.insert(helper.BEHAVIOR_TABLE, helper.B_THERAPIST_ID, contentValues);
        return id;
    }

/*    public ArrayList<String> getBehaviors(){
        ArrayList<String> result = new ArrayList<String>();
        int currentId;
        String currentName;
        SQLiteDatabase db = helper.getWritableDatabase();
        String[] columns = {helper.BEHAVIOR_ID, helper.BEHAVIOR_NAME};
        Cursor cursor = db.query(helper.BEHAVIOR_TABLE, columns, null, null, null, null, null);
        while(cursor.moveToNext()){
            int indexForId = cursor.getColumnIndex(helper.BEHAVIOR_ID);
            int indexForName = cursor.getColumnIndex(helper.BEHAVIOR_NAME);
            currentId = cursor.getInt(indexForId);
            currentName = cursor.getString(indexForName);
            result.add(currentId + " " + currentName);
        }
        return result;
    }*/

    public ArrayList<Behavior> getBehaviors(){
        ArrayList<Behavior> result = new ArrayList<Behavior>();
        int currentId;
        String currentName;
        SQLiteDatabase db = helper.getWritableDatabase();
        String[] columns = {helper.BEHAVIOR_ID, helper.BEHAVIOR_NAME};
        Cursor cursor = db.query(helper.BEHAVIOR_TABLE, columns, null, null, null, null, null);
        while(cursor.moveToNext()){
            int indexForId = cursor.getColumnIndex(helper.BEHAVIOR_ID);
            int indexForName = cursor.getColumnIndex(helper.BEHAVIOR_NAME);
            currentId = cursor.getInt(indexForId);
            currentName = cursor.getString(indexForName);
            result.add(new Behavior(currentId, currentName));
        }
        return result;
    }

    static class JITDatabaseHelper extends SQLiteOpenHelper{
        private static final String DATABASE_NAME = "JustInTimeCBT";
        private static final int DATABASE_VERSION = 4;

        //For Therapist Table
        private static final String THERAPIST_TABLE = "Therapist";
        private static final String THERAPIST_ID = "TherapistId";
        private static final String PREFIX = "Prefix";
        private static final String FIRST_NAME = "FirstName";
        private static final String MIDDLE_INITIAL = "MiddleInitial";
        private static final String LAST_NAME = "LastName";
        private static final String SUFFIX = "Suffix";
        private static final String EMAIL = "Email";
        private static final String PHONE = "Phone";
        private static final String CREATE_THERAPIST_TABLE = "CREATE TABLE " + THERAPIST_TABLE + " (" + THERAPIST_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + PREFIX + " TEXT, " +
                FIRST_NAME + " TEXT NOT NULL, " + MIDDLE_INITIAL + " TEXT, " + LAST_NAME + " TEXT NOT NULL, " + SUFFIX + " TEXT, " + EMAIL + " TEXT, " + PHONE + " TEXT);";
        private static final String DROP_THERAPIST_TABLE = "DROP TABLE IF EXISTS " + THERAPIST_TABLE;

        //For Behavior Table
        private static final String BEHAVIOR_TABLE = "Behavior";
        private static final String BEHAVIOR_ID = "BehaviorId";
        private static final String BEHAVIOR_NAME = "Name";
        private static final String B_THERAPIST_ID = "TherapistId";
        private static final String CREATE_BEHAVIOR_TABLE = "CREATE TABLE " + BEHAVIOR_TABLE + " (" + BEHAVIOR_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + BEHAVIOR_NAME + " TEXT NOT NULL, " +
                B_THERAPIST_ID + " INTEGER, FOREIGN KEY (" + B_THERAPIST_ID + ") REFERENCES " + THERAPIST_TABLE + " (" + B_THERAPIST_ID + "));";
        private static final String DROP_BEHAVIOR_TABLE = "DROP TABLE IF EXISTS " + BEHAVIOR_TABLE;

        //For Trigger Table
        private static final String TRIGGER_TABLE = "Trigger";
        private static final String TRIGGER_ID = "TriggerId";
        private static final String TRIGGER_NAME = "Name";
        private static final String TR_BEHAVIOR_ID = "BehaviorId";
        private static final String TR_THERAPIST_ID = "TherapistId";
        private static final String T_RANK = "Rank";
        private static final String CREATE_TRIGGER_TABLE = "CREATE TABLE " + TRIGGER_TABLE + " (" + TRIGGER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + TRIGGER_NAME + " TEXT NOT NULL, " +
                TR_BEHAVIOR_ID + " INTEGER NOT NULL, " + TR_THERAPIST_ID + " INTEGER, " + T_RANK + " INTEGER, FOREIGN KEY (" + TR_BEHAVIOR_ID + ") REFERENCES " + BEHAVIOR_TABLE + " (" + BEHAVIOR_ID + "), " +
                "FOREIGN KEY (" + TR_THERAPIST_ID + ") REFERENCES " + THERAPIST_TABLE + " (" + THERAPIST_ID + "));";
        private static final String DROP_TRIGGER_TABLE = "DROP TABLE IF EXISTS " + TRIGGER_TABLE;

        //For ShutDown Table
        private static final String SHUTDOWN_TABLE = "Shutdown";
        private static final String SHUTDOWN_ID = "ShutdownId";
        private static final String SHUTDOWN_MESSAGE = "Message";
        private static final String SD_TRIGGER_ID = "TriggerId";
        private static final String SD_THERAPIST_ID = "TherapistId";
        private static final String SHUTDOWN_RANK = "Rank";
        private static final String CREATE_SHUTDOWN_TABLE = "CREATE TABLE " + SHUTDOWN_TABLE + " (" + SHUTDOWN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + SHUTDOWN_MESSAGE + " TEXT NOT NULL, " +
                SD_TRIGGER_ID + " INTEGER NOT NULL, " + SD_THERAPIST_ID + " INTEGER, " + SHUTDOWN_RANK + " INTEGER, FOREIGN KEY (" + SD_TRIGGER_ID + ") REFERENCES " + TRIGGER_TABLE + " (" + TRIGGER_ID + "), " +
                "FOREIGN KEY (" + SD_THERAPIST_ID + ") REFERENCES " + THERAPIST_TABLE + " (" + THERAPIST_ID + "));";
        private static final String DROP_SHUTDOWN_TABLE = "DROP TABLE IF EXISTS " + SHUTDOWN_TABLE;

        //For Rationalization Table
        private static final String RATIONALIZATION_TABLE = "Rationalization";
        private static final String RATIONALIZATION_ID = "RationalizationId";
        private static final String RATIONALIZATION_MESSAGE = "Message";
        private static final String RA_BEHAVIOR_ID = "BehaviorId";
        private static final String RA_THERAPIST_ID = "TherapistId";
        private static final String CREATE_RATIONALIZATION_TABLE = "CREATE TABLE " + RATIONALIZATION_TABLE + " (" + RATIONALIZATION_ID +
                " INTEGER PRIMARY KEY AUTOINCREMENT, " + RATIONALIZATION_MESSAGE + " TEXT NOT NULL, " + RA_BEHAVIOR_ID + " INTEGER NOT NULL, " +
                RA_THERAPIST_ID + " INTEGER, FOREIGN KEY (" + RA_THERAPIST_ID + ") REFERENCES " + THERAPIST_TABLE + " (" + THERAPIST_ID + "), " +
                "FOREIGN KEY (" + RA_BEHAVIOR_ID + ") REFERENCES " + BEHAVIOR_TABLE + " (" + BEHAVIOR_ID + "));";
        private static final String DROP_RATIONALIZATION_TABLE = "DROP TABLE IF EXISTS " + RATIONALIZATION_TABLE;

        //For LogicalResponse Table
        private static final String LOGICAL_RESPONSE_TABLE = "LogicalResponse";
        private static final String LOGICAL_RESPONSE_ID = "LogicalResponseId";
        private static final String LOGICAL_RESPONSE_MESSAGE = "Messsage";
        private static final String LR_RATIONALIZATION_ID = "RationalizationId";
        private static final String LR_THERAPIST_ID = "TherapistId";
        private static final String CREATE_LOGICAL_RESPONSE_TABLE = "CREATE TABLE " + LOGICAL_RESPONSE_TABLE + " (" + LOGICAL_RESPONSE_ID +
                " INTEGER PRIMARY KEY AUTOINCREMENT, " + LOGICAL_RESPONSE_MESSAGE + " TEXT NOT NULL, " + LR_RATIONALIZATION_ID + " INTEGER NOT NULL, " +
                LR_THERAPIST_ID + " INTEGER, " + "FOREIGN KEY (" + LR_RATIONALIZATION_ID + ") REFERENCES " + RATIONALIZATION_TABLE + " (" + RATIONALIZATION_ID +
                "), FOREIGN KEY (" + LR_THERAPIST_ID + ") REFERENCES " + THERAPIST_TABLE + " (" + THERAPIST_ID + "));";
        private static final String DROP_LOGICAL_RESPONSE_TABLE = "DROP TABLE IF EXISTS " + LOGICAL_RESPONSE_TABLE;

        //For Alternative table
        private static final String ALTERNATIVE_TABLE = "Alternative";
        private static final String ALTERNATIVE_ID = "AlternativeId";
        private static final String ALTERNATIVE_MESSAGE = "Message";
        private static final String AL_BEHAVIOR_ID = "BehaviorId";
        private static final String AL_THERAPIST_ID = "TherapistId";
        private static final String CREATE_ALTERNATIVE_TABLE = "CREATE TABLE " + ALTERNATIVE_TABLE + " (" + ALTERNATIVE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ALTERNATIVE_MESSAGE + " TEXT NOT NULL, " + AL_BEHAVIOR_ID + " INTEGER NOT NULL, " + AL_THERAPIST_ID + " INTEGER, FOREIGN KEY (" + AL_BEHAVIOR_ID + ") REFERENCES " +
                BEHAVIOR_TABLE + " (" + BEHAVIOR_ID + "), FOREIGN KEY (" + AL_THERAPIST_ID + ") REFERENCES " + THERAPIST_TABLE + " (" + THERAPIST_ID + "));";
        private static final String DROP_ALTERNATIVE_TABLE = "DROP TABLE IF EXISTS " + ALTERNATIVE_TABLE;

        //For Consequence table
        private static final String CONSEQUENCE_TABLE = "Consequence";
        private static final String CONSEQUENCE_ID = "ConsequenceId";
        private static final String CONSEQUENCE_MESSAGE = "Message";
        private static final String CO_BEHAVIOR_ID = "BehaviorId";
        private static final String CO_THERAPIST_ID = "TherapistId";
        private static final String CREATE_CONSEQUENCE_TABLE = "CREATE TABLE " + CONSEQUENCE_TABLE + " (" + CONSEQUENCE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                CONSEQUENCE_MESSAGE + " TEXT NOT NULL, " + CO_BEHAVIOR_ID + " INTEGER NOT NULL, " + CO_THERAPIST_ID + " INTEGER, FOREIGN KEY (" + CO_BEHAVIOR_ID + ") REFERENCES " +
                BEHAVIOR_TABLE + " (" + BEHAVIOR_ID + "), FOREIGN KEY (" + CO_THERAPIST_ID + ") REFERENCES " + THERAPIST_TABLE + " (" + THERAPIST_ID + "));";
        private static final String DROP_CONSEQUENCE_TABLE = "DROP TABLE IF EXISTS " + CONSEQUENCE_TABLE;

        //For Life Area table
        private static final String LIFE_AREA_TABLE = "LifeArea";
        private static final String LIFE_AREA_ID = "LifeAreaId";
        private static final String LIFE_AREA_NAME = "Name";
        private static final String LIFE_AREA_ACTIVE = "Active";
        private static final String LA_THERAPIST_ID = "TherapistId";
        private static final String CREATE_LIFE_AREA_TABLE = "CREATE TABLE " + LIFE_AREA_TABLE + " (" + LIFE_AREA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                LIFE_AREA_NAME + " TEXT NOT NULL, " + LIFE_AREA_ACTIVE + " INTEGER NOT NULL DEFAULT 1, " + LA_THERAPIST_ID + " INTEGER, FOREIGN KEY (" + LA_THERAPIST_ID +
                ") REFERENCES " + THERAPIST_TABLE + " (" + THERAPIST_ID + "));";
        private static final String  DROP_LIFE_AREA_TABLE = "DROP TABLE IF EXISTS " + LIFE_AREA_TABLE;

        //For Thought table
        private static final String THOUGHT_TABLE = "Thought";
        private static final String THOUGHT_ID = "ThoughtId";
        private static final String THOUGHT_MESSAGE = "Message";
        private static final String THOUGHT_ACTIVE = "Active";
        private static final String TH_THERAPIST_ID = "TherapistId";
        private static final String TH_LIFE_AREA_ID = "LifeAreaId";
        private static final String CREATE_THOUGHT_TABLE = "CREATE TABLE " + THOUGHT_TABLE + " (" + THOUGHT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                THOUGHT_MESSAGE + " TEXT NOT NULL, " + THOUGHT_ACTIVE + " INTEGER NOT NULL DEFAULT 1, " + TH_LIFE_AREA_ID + " INTEGER NOT NULL, " + TH_THERAPIST_ID + " INTEGER, FOREIGN KEY (" + TH_THERAPIST_ID +
                ") REFERENCES " + THERAPIST_TABLE + " (" + THERAPIST_ID + "), FOREIGN KEY (" + TH_LIFE_AREA_ID + ") REFERENCES " + LIFE_AREA_TABLE + " (" + LIFE_AREA_ID + "));";
        private static final String  DROP_THOUGHT_TABLE = "DROP TABLE IF EXISTS " + THOUGHT_TABLE;

        //For Thoughts of the Day table
        private static final String THOUGHTS_OF_THE_DAY_TABLE = "ThoughtsOfTheDay";
        private static final String THOUGHTS_OF_THE_DAY_ID = "ThoughtsOfTheDayId";
        private static final String THOUGHTS_OF_THE_DAY_NAME = "Name";
        private static final String TOTD_THERAPIST_ID = "TherapistId";
        private static final String THOUGHTS_OF_THE_DAY_DATE_CREATED = "DateCreated";
        private static final String CREATE_THOUGHTS_OF_THE_DAY_TABLE = "CREATE TABLE " + THOUGHTS_OF_THE_DAY_TABLE + " (" + THOUGHTS_OF_THE_DAY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                THOUGHTS_OF_THE_DAY_NAME + " TEXT NOT NULL, " + THOUGHTS_OF_THE_DAY_DATE_CREATED + " TEXT NOT NULL, " + TOTD_THERAPIST_ID + " INTEGER, FOREIGN KEY (" + TOTD_THERAPIST_ID +
                ") REFERENCES " + THERAPIST_TABLE + " (" + THERAPIST_ID + "));";
        private static final String  DROP_THOUGHTS_OF_THE_DAY_TABLE = "DROP TABLE IF EXISTS " + THOUGHTS_OF_THE_DAY_TABLE;

        //For Thoughts has thought table
        private static final String THOUGHTS_HAS_THOUGHT_TABLE = "ThoughtsHasThought";
        private static final String THOUGHTS_HAS_THOUGHT_ID = "ThoughtsHasThoughtId";
        private static final String THT_THOUGHTS_OF_THE_DAY_ID = "ThoughtsOfTheDayId";
        private static final String THT_THOUGHT_ID = "ThoughtId";
        private static final String CREATE_THOUGHTS_HAS_THOUGHT_TABLE = "CREATE TABLE " + THOUGHTS_HAS_THOUGHT_TABLE + " (" + THOUGHTS_HAS_THOUGHT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                THT_THOUGHTS_OF_THE_DAY_ID + " INTEGER NOT NULL, " + THT_THOUGHT_ID + " INTEGER NOT NULL, " + " FOREIGN KEY (" + THT_THOUGHTS_OF_THE_DAY_ID +
                ") REFERENCES " + THOUGHTS_OF_THE_DAY_TABLE + " (" + THOUGHTS_OF_THE_DAY_ID + "), FOREIGN KEY (" + THT_THOUGHT_ID + ") REFERENCES " +
                THOUGHT_TABLE + " (" + THOUGHT_ID + "));";
        private static final String  DROP_THOUGHTS_HAS_THOUGHT_TABLE = "DROP TABLE IF EXISTS " + THOUGHTS_HAS_THOUGHT_TABLE;

        //FOr Goal table
        private static final String GOAL_TABLE = "Goal";
        private static final String GOAL_ID = "GoalId";
        private static final String GOAL_NAME = "Name";
        private static final String GOAL_RANK = "Rank";
        private static final String GOAL_THERAPIST_ID = "TherapistId";
        private static final String CREATE_GOAL_TABLE = "CREATE TABLE " + GOAL_TABLE + " (" + GOAL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                GOAL_NAME + " TEXT NOT NULL, " + GOAL_RANK + " INTEGER, " + GOAL_THERAPIST_ID + " INTEGER, " + " FOREIGN KEY (" + GOAL_THERAPIST_ID + ") REFERENCES " +
                THERAPIST_TABLE + " (" + THERAPIST_ID + "));";
        private static final String  DROP_GOAL_TABLE = "DROP TABLE IF EXISTS " + GOAL_TABLE;

        //FOr Achievement table
        private static final String ACHIEVEMENT_TABLE = "Achievement";
        private static final String ACHIEVEMENT_ID = "AchievementId";
        private static final String ACHIEVEMENT_DATE = "Date";
        private static final String ACH_GOAL_ID = "GoalId";
        private static final String CREATE_ACHIEVEMENT_TABLE = "CREATE TABLE " + ACHIEVEMENT_TABLE + " (" + ACHIEVEMENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ACHIEVEMENT_DATE + " TEXT NOT NULL, " + ACH_GOAL_ID + " INTEGER NOT NULL, FOREIGN KEY (" + ACH_GOAL_ID + ") REFERENCES " +
                GOAL_TABLE + " (" + GOAL_ID + "));";
        private static final String  DROP_ACHIEVEMENT_TABLE = "DROP TABLE IF EXISTS " + ACHIEVEMENT_TABLE;

        //For Benefit table
        private static final String BENEFIT_TABLE = "Benefit";
        private static final String BENEFIT_ID = "BenefitId";
        private static final String BENEFIT_MESSAGE = "Message";
        private static final String BEN_THERAPIST_ID = "TherapistId";
        private static final String BEN_GOAL_ID = "GoalId";
        private static final String CREATE_BENEFIT_TABLE = "CREATE TABLE " + BENEFIT_TABLE + " (" + BENEFIT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                BENEFIT_MESSAGE + " TEXT NOT NULL, " +  BEN_GOAL_ID + " INTEGER NOT NULL, " + BEN_THERAPIST_ID + " INTEGER, FOREIGN KEY (" + BEN_THERAPIST_ID +
                ") REFERENCES " + THERAPIST_TABLE + " (" + THERAPIST_ID + "), FOREIGN KEY (" + BEN_GOAL_ID + ") REFERENCES " + GOAL_TABLE + " (" + GOAL_ID + "));";
        private static final String  DROP_BENEFIT_TABLE = "DROP TABLE IF EXISTS " + BENEFIT_TABLE;

        private Context context;

        public JITDatabaseHelper(Context context) {

            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            this.context=context;
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try {
                db.execSQL(CREATE_THERAPIST_TABLE);
                db.execSQL(CREATE_BEHAVIOR_TABLE);
                db.execSQL(CREATE_TRIGGER_TABLE);
                db.execSQL(CREATE_SHUTDOWN_TABLE);
                db.execSQL(CREATE_RATIONALIZATION_TABLE);
                db.execSQL(CREATE_LOGICAL_RESPONSE_TABLE);
                db.execSQL(CREATE_ALTERNATIVE_TABLE);
                db.execSQL(CREATE_CONSEQUENCE_TABLE);
                db.execSQL(CREATE_LIFE_AREA_TABLE);
                db.execSQL(CREATE_THOUGHT_TABLE);
                db.execSQL(CREATE_THOUGHTS_OF_THE_DAY_TABLE);
                db.execSQL(CREATE_THOUGHTS_HAS_THOUGHT_TABLE);
                db.execSQL(CREATE_GOAL_TABLE);
                db.execSQL(CREATE_ACHIEVEMENT_TABLE);
                db.execSQL(CREATE_BENEFIT_TABLE);
            }
            catch(android.database.SQLException e){
                Log.e("Database Exception", "onCreate: " + e.getMessage());
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            try{
                db.execSQL(DROP_THERAPIST_TABLE);
                db.execSQL(DROP_BEHAVIOR_TABLE);
                db.execSQL(DROP_TRIGGER_TABLE);
                db.execSQL(DROP_SHUTDOWN_TABLE);
                db.execSQL(DROP_RATIONALIZATION_TABLE);
                db.execSQL(DROP_LOGICAL_RESPONSE_TABLE);
                db.execSQL(DROP_ALTERNATIVE_TABLE);
                db.execSQL(DROP_CONSEQUENCE_TABLE);
                db.execSQL(DROP_LIFE_AREA_TABLE);
                db.execSQL(DROP_THOUGHT_TABLE);
                db.execSQL(DROP_THOUGHTS_OF_THE_DAY_TABLE);
                db.execSQL(DROP_THOUGHTS_HAS_THOUGHT_TABLE);
                db.execSQL(DROP_GOAL_TABLE);
                db.execSQL(DROP_ACHIEVEMENT_TABLE);
                db.execSQL(DROP_BENEFIT_TABLE);
                onCreate(db);
            }
            catch(android.database.SQLException e){
                Log.e("Database Exception", "onUpgrade: " + e.getMessage());
            }
        }
    }
}