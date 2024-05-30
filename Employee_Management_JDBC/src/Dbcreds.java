public class Dbcreds {
    private final String url = "jdbc:postgresql://localhost:5432/project";
    private final String userName = "postgres";
    private final String pass = "5353";

    public String getUrl()
    {
        return url;
    }
    public String getUserName()
    {
        return userName;
    }
    public String getPass()
    {
        return pass;
    }

}
