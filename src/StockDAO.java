/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

/**
 *
 * @author phamduchoang
 */
public class StockDAO implements Serializable {

    private Connection conn;
    private PreparedStatement preStm;
    private ResultSet rs;

    private void closeConnection() throws Exception {
        if (rs != null) {
            rs.close();
        }
        if (preStm != null) {
            preStm.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    public void insert(Vector<StockDTO> vec) throws Exception {
        String sql = "INSERT INTO Stocks(StockID, StockName, Address, DateAvailable, Note) VALUES(?,?,?,?,?)";
        try {
            conn = MyConnection.getConnect();
            conn.setAutoCommit(false);
            preStm = conn.prepareStatement(sql);
            for (StockDTO dto : vec) {
                preStm.setString(1, dto.getStockID());
                preStm.setString(2, dto.getStockName());
                preStm.setString(3, dto.getAddress());
                preStm.setString(4, dto.getDateAvailable());
                preStm.setString(5, dto.getNote());
                preStm.executeUpdate();
            }
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }
}




































































































































//public void insert(Vector<StockDTO> vec) throws Exception {
//        String sql = "INSERT INTO Stocks(StockID, StockName, Address, DateAvailable, Note) VALUES(?,?,?,?,?)";
//        try {
//            conn = MyConnection.getConnect();
//            conn.setAutoCommit(false);
//            preStm = conn.prepareStatement(sql);
//            for (StockDTO dto : vec) {
//                preStm.setString(1, dto.getStockID());
//                preStm.setString(2, dto.getStockName());
//                preStm.setString(3, dto.getAddress());
//                preStm.setString(4, dto.getDateAvailable());
//                preStm.setString(5, dto.getNote());
//                preStm.executeUpdate();
//            }
//            conn.commit();
//        } catch (Exception e) {
//            conn.rollback();
//            e.printStackTrace();
//        } finally {
//            closeConnection();
//        }
//    }