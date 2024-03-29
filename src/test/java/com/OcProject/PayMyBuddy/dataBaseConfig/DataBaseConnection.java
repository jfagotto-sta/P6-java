//package com.OcProject.PayMyBuddy.dataBaseConfig;
//
//import com.OcProject.PayMyBuddy.DataBaseConfig.DataBaseConfig;
//import org.apache.logging.log4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//public class DataBaseConnection extends DataBaseConfig {
//
//    private static final Logger logger = (Logger) LoggerFactory.getLogger("this.class");
//
//    public Connection getConnection() throws ClassNotFoundException, SQLException {
//        logger.info("Create DB connection");
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        return DriverManager.getConnection(
//                "jdbc:mysql://localhost:3306/pmbtest?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","root");
//    }
//
//    public void closeConnection(Connection con){
//        if(con!=null){
//            try {
//                con.close();
//                logger.info("Closing DB connection");
//            } catch (SQLException e) {
//                logger.error("Error while closing connection",e);
//            }
//        }
//    }
//}
