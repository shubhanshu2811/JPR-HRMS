package com.jpr_hrms.db;

import android.util.Log;

import com.jpr_hrms.modell.Employee;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.exceptions.RealmException;

public class DBHelper implements IDbHelper {


    static DBHelper dbHelper = null;
    static Realm realm = null;


    public static DBHelper getInstance(){

        if (dbHelper== null);
        {
            dbHelper = new DBHelper();
            realm = Realm.getDefaultInstance();

        }
         return (dbHelper);
    }



    @Override
    public int createEmploye(final Employee employe) {

        try {

            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    realm.copyToRealmOrUpdate(employe);
                    Log.d("DBHelper", "execute: ");

                }
            });
        } catch (RealmException e) {
            e.printStackTrace();
            return -1;
        }
        return 1;
    }

    @Override
    public Employee getEmploye(String empId) {
        Employee employee = null;
        RealmResults<Employee> allEmps = realm.where(Employee.class).equalTo("empId", empId).findAll();

        if (allEmps!=null && allEmps.size()>0){

            employee = allEmps.first();
        }

        return employee;
    }

    @Override
    public void updateEmploye(Employee employe) {

    }

    @Override
    public int deleteEmploye(final Employee employe) {

        try{
            realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                employe.deleteFromRealm();

            }
        });}catch (Exception e){
            e.printStackTrace();

            return -1;
        }
        return 1;

    }

    @Override
    public List<Employee> getAllEmploye() {
        try {
            RealmResults<Employee> allemploye = realm.where(Employee.class).equalTo("pin", 0).findAll();
            return allemploye;
        }catch (Exception e){

            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Employee getEmpByIDANDPassword(int empId, String password) {
        return null;
    }

    @Override
    public Employee getEmpByPin(int pin) {

        Employee employee = null;
        RealmResults<Employee> employeActivities = realm.where(Employee.class).equalTo("pin", pin).findAll();

        if (employeActivities!=null && employeActivities.size()>0){

            employee = employeActivities.first();
        }
        return employee;
    }
}
