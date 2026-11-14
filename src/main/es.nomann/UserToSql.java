package es.nomann;

import java.sql.*;
import java.util.Properties;

public class UserToSql {

    public UserToSql() throws SQLException {
        CsvReader reader = new CsvReader(System.getenv("BANKDATA_DIR") + "/users_data.csv");
        int limit = 2000;
        var map = reader.readFile(limit);

        String url = "jdbc:postgresql://localhost/transactions";
        Properties props = new Properties();
        props.setProperty("user", System.getenv("DB_USER"));
        props.setProperty("password", System.getenv("DB_PASSWORD"));
        props.setProperty("ssl", "false");

        Connection conn = DriverManager.getConnection(url, props);

        for (int j = 0; j < limit; j++) {
            User user = new User();

            for (var key : map.keySet()) {
                String value = map.get(key).get(j).trim();

                switch (key) {
                    case "id":
                        user.setId(Integer.parseInt(value.replace("[", "")));
                        break;

                    case "current_age":
                        user.setCurrentAge(Integer.parseInt(value));
                        break;

                    case "retirement_age":
                        user.setRetirementAge(Integer.parseInt(value));
                        break;

                    case "birth_year":
                        user.setBirthYear(Integer.parseInt(value));
                        break;

                    case "birth_month":
                        user.setBirthMonth(Integer.parseInt(value));
                        break;

                    case "gender":
                        user.setGender(value);
                        break;

                    case "address":
                        user.setAddress(value);
                        break;

                    case "latitude":
                        user.setLatitude(Double.parseDouble(value));
                        break;

                    case "longitude":
                        user.setLongitude(Double.parseDouble(value));
                        break;

                    case "per_capita_income":
                        user.setPerCapitaIncome(
                                Integer.parseInt(value.replace("$", "").replace(",", ""))
                        );
                        break;

                    case "yearly_income":
                        user.setYearlyIncome(
                                Integer.parseInt(value.replace("$", "").replace(",", ""))
                        );
                        break;

                    case "total_debt":
                        user.setTotalDebt(
                                Integer.parseInt(value.replace("$", "").replace(",", ""))
                        );
                        break;

                    case "credit_score":
                        user.setCreditScore(Integer.parseInt(value));
                        break;

                    case "num_credit_cards":
                        user.setNumCreditCards(Integer.parseInt(value.replace("]","")));
                        break;
                }
            }

            PreparedStatement st = conn.prepareStatement(
                    "INSERT INTO users (" +
                            "id, current_age, retirement_age, birth_year, birth_month, " +
                            "gender, address, latitude, longitude, per_capita_income, " +
                            "yearly_income, total_debt, credit_score, num_credit_cards" +
                            ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
            );

            st.setInt(1, user.getId());
            st.setInt(2, user.getCurrentAge());
            st.setInt(3, user.getRetirementAge());
            st.setInt(4, user.getBirthYear());
            st.setInt(5, user.getBirthMonth());
            st.setString(6, user.getGender());
            st.setString(7, user.getAddress());
            st.setDouble(8, user.getLatitude());
            st.setDouble(9, user.getLongitude());
            st.setInt(10, user.getPerCapitaIncome());
            st.setInt(11, user.getYearlyIncome());
            st.setInt(12, user.getTotalDebt());
            st.setInt(13, user.getCreditScore());
            st.setInt(14, user.getNumCreditCards());

            //st.executeUpdate();
            st.close();
        }

        PreparedStatement st2 = conn.prepareStatement("SELECT DISTINCT yearly_income,total_debt,credit_score FROM users LEFT JOIN cards ON users.id = cards.client_id");
        ResultSet set  = st2.executeQuery();
        while (set.next()) {
           System.out.print(set.getObject("yearly_income") + " ");
           System.out.println(set.getObject("total_debt"));
        }
        st2.close();


        conn.close();
        System.out.println("ok");
    }
}
