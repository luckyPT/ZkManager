package top.letsgogo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author panteng
 * @description
 * @date 17-7-10.
 */
@Service
public class MysqlDbService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<String> getAreasName() {
        String sql = "SELECT name FROM city_locale WHERE locale = 'zh_CN' AND affiliation LIKE '%中国%'";
        try {
            List<String> areasName = jdbcTemplate.queryForList(sql, String.class);
            return areasName;
        } catch (Exception e) {
            System.out.println("查询MSQL 地域名出现异常：" + e.getMessage());
        }
        return new ArrayList<String>();
    }
}
