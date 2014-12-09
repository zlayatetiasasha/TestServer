/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.dao;

import java.sql.SQLException;
import java.util.List;
import test.panels.Statistics;
/**
 *
 * @author Asus
 */
public interface StatisticsDAO {
    // add statistics
    public void addStatistics(Statistics statistics) throws SQLException;  
    // update statistics
    public void updateStatistics(Statistics statistics) throws SQLException;
    // get statistics by id
    public Statistics getStatisticsById(Long id) throws SQLException;    
    // get all statistics
    public List<Statistics> getAllStatistics() throws SQLException;        
    // delete statistics
    public void deleteStatistics(Statistics statistics) throws SQLException;
}