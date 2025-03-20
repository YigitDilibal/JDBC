package stepDefinitions;

import io.cucumber.java.en.Given;
import manage.QueryManage;
import org.testng.Assert;
import utilities.JDBCReusableMethods;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class StepDefinition {

    Connection connection;
    Statement statement;
    ResultSet resultSet;
    QueryManage queryManage = new QueryManage();
    String Query;
    PreparedStatement preparedStatement;
    int row;


    @Given("Database ile baglanti kurulur.")
    public void database_ile_baglanti_kurulur() throws SQLException {

        String URL= "jdbc:mysql://195.35.59.18/u201212290_qaloantec";
        String USERNAME= "u201212290_qaloanuser";
        String PASSWORD= "HPo?+7r$";

        connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
    }



    @Given("SQL Query'si hazirlanir.")
    public void sql_query_si_hazirlanir() throws SQLException {

        String Query = "select distinct user_id from deposits WHERE amount between 100 AND 500" ;
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        resultSet = statement.executeQuery(Query);

    }


    @Given("Databaseden sonuclar dogrulanir.")
    public void databaseden_sonuclar_dogrulanir() throws SQLException {

        //1
        //9
        //10
        //12
        //64

        List<Integer> expectedResultList = new ArrayList<>(Arrays.asList(1,9,10,12,64));

        List<Integer> actualResultList = new ArrayList<>();

        while (resultSet.next()){
            actualResultList.add(resultSet.getInt("user_id"));
        }

        assertEqualsNoOrder(actualResultList,expectedResultList);

    }



    @Given("Database baglantisi kapatilir.")
    public void database_baglantisi_kapatilir() throws SQLException {

        resultSet.close();
        statement.close();
        connection.close();

    }


    @Given("cron_schedules SQL Query'si hazirlanir.")
    public void cron_schedules_sql_query_si_hazirlanir() throws SQLException {

        Query = queryManage.getCroneSchedulesQuery();
        resultSet = JDBCReusableMethods.executeQuery(Query);


    }
    @Given("cron_schedules Databaseden sonuclar dogrulanir.")
    public void cron_schedules_databaseden_sonuclar_dogrulanir() throws SQLException {

        List<String> expectedResultList = new ArrayList<>();
        expectedResultList.add("5 Minutes");
        expectedResultList.add("10 Minutes");

        List<String> actualResultList = new ArrayList<>();

        while (resultSet.next()){
            actualResultList.add(resultSet.getString("name"));
        }

    }


//------------------------------


    @Given("Database baglantisi olusturulur.")
    public void database_baglantisi_olusturulur() {

        JDBCReusableMethods.createConnection();
    }


    @Given("\\(users) SQL Query'si hazirlanir ve calistirilir.")
    public void users_sql_query_si_hazirlanir_ve_calistirilir() throws SQLException {

        Query = queryManage.getUsersUpdateQuery();
        preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(Query);


        //  UPDATE users SET mobile = ? WHERE username like ?;

        preparedStatement.setString(1, "77777");
        preparedStatement.setString(2, "%e_");

        row = preparedStatement.executeUpdate();

    }


    @Given("\\(users) sonuclar islenir")
    public void users_sonuclar_islenir() {

        System.out.println("etkilenen satir sayisi: " + row);
        assertEquals(row, 5);

    }


    @Given("\\(users) database baglantisi sonlandirilir.")
    public void users_database_baglantisi_sonlandirilir() {

        JDBCReusableMethods.closeConnection();

    }




}
