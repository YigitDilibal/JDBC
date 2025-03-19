package stepDefinitions;

import io.cucumber.java.en.Given;
import org.testng.Assert;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class StepDefinition {

    Connection connection;
    Statement statement;
    ResultSet resultSet;


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


}
