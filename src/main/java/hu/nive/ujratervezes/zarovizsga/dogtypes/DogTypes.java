package hu.nive.ujratervezes.zarovizsga.dogtypes;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class DogTypes {

    private final DataSource dataSource;

    public DogTypes(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> getDogsByCountry(String country) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("select name from dog_types where country = ?")) {
            ps.setString(1, country);
            return selectDogsByCountryByPS(ps);
        } catch (SQLException se) {
            throw new IllegalStateException("Connection failed!", se);
        }
    }

    private List<String> selectDogsByCountryByPS(PreparedStatement ps) {
        List<String> result = new LinkedList<>();
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                result.add(rs.getString("name").toLowerCase());
            }
            Collections.sort(result);
            return result;
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot query!", se);
        }
    }
}
