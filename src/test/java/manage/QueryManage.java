package manage;

public class QueryManage {


    private String croneSchedulesQuery = "select name from cron_schedules limit 2;";




    public String getCroneSchedulesQuery() {
        return croneSchedulesQuery;
    }
}
