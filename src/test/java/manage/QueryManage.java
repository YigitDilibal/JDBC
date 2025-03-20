package manage;

public class QueryManage {


    private String croneSchedulesQuery = "select name from cron_schedules limit 2;";
    private String usersUpdateQuery = "UPDATE users SET mobile = ? WHERE username like ?;";
    private String deviceTokensInsertQuery = "insert into device_tokens (id, user_id,is_app, token)values (?, ?, ?, ?)";
    private String deviceTokensInsertDogrulama = "Select * FROM device_tokens WHERE id = ?";




    public String getDeviceTokensInsertDogrulama() {
        return deviceTokensInsertDogrulama;
    }

    public String getDeviceTokensInsertQuery() {
        return deviceTokensInsertQuery;
    }

    public String getCroneSchedulesQuery() {
        return croneSchedulesQuery;
    }

    public String getUsersUpdateQuery() {
        return usersUpdateQuery;
    }
}
