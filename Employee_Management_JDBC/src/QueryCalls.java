public class QueryCalls {
    final String insert = "insert into %s(id,name, email) values('%d','%s', '%s');";
    final String delete = "DELETE FROM %s  WHERE id ='%d'";
    final String update = "update %s SET name='%s' where name='%s'";
    final String read = "SELECT * FROM %s";

    public String Insert() {
        return insert;
    }

    public String Delete() {
        return delete;
    }

    public String Update() {
        return update;
    }

    public String Read() {
        return read;
    }
}
