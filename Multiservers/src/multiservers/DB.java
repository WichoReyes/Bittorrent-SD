package multiservers;

/**
 *
 * @author Alumnos
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {

    public Connection conn = null;

    public DB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/peers?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
//poner el usuario y password que tenga definido en Mysql
            conn = DriverManager.getConnection(url, "root", "BasesDeDatos");
            System.out.println("conn built");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ResultSet runSql(String sql) throws SQLException {
        Statement sta = conn.createStatement();
        System.out.println("runsql");
        return sta.executeQuery(sql);
    }

    public void exe(String sql) throws SQLException {
        Statement sta = conn.createStatement();
        sta.executeUpdate(sql);
        System.out.println("Se agrego correctamente");
    }

    protected void finalize() throws Throwable {
        if (conn != null || !conn.isClosed()) {
            conn.close();
        }
        System.out.println("Conexion cerrada");
    }

}
