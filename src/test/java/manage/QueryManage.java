package manage;

public class QueryManage {


    private String croneSchedulesQuery = "select name from cron_schedules limit 2;";
    private String usersUpdateQuery = "UPDATE users SET mobile = ? WHERE username like ?;";



    public String getCroneSchedulesQuery() {
        return croneSchedulesQuery;
    }

    public String getUsersUpdateQuery() {
        return usersUpdateQuery;
    }
}
