package es.nomann;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class Main {

    static void main() throws SQLException {
        CsvReader reader = new CsvReader(System.getenv("BANKDATA_DIR") + "/cards_data.csv");
        int limit = 6000;
        var map = reader.readFile(limit);
        new UserToSql();
       /* Cards cards = new Cards();

        String url = "jdbc:postgresql://localhost/transactions";
        Properties props = new Properties();
        props.setProperty("user", System.getenv("DB_USER"));
        props.setProperty("password", System.getenv("DB_PASSWORD"));
        props.setProperty("ssl", "false");
        Connection conn = DriverManager.getConnection(url, props);
        for (int j = 0; j<limit; j++) {
            Card card = new Card();
            for(var keys:  map.keySet()){
                switch (keys) {
                    case "id":
                        card.setId(Integer.parseInt(map.get(keys).get(j).replace("[", "")));
                        break;
                    case "client_id":
                        card.setClientId(Integer.parseInt(map.get(keys).get(j).trim()));
                        break;
                    case "card_brand":
                        card.setCardBrand(map.get(keys).get(j).trim());
                        break;
                    case "card_type":
                        card.setCardType(map.get(keys).get(j).trim());
                        break;
                    case "card_number":
                        card.setCardNumber(Long.parseLong((map.get(keys).get(j).trim())));
                        break;
                    case "expires":
                        card.setExpires(map.get(keys).get(j).trim());
                        break;
                    case "cvv":
                        card.setCvv(Integer.parseInt(map.get(keys).get(j).trim()));
                        break;
                    case "has_chip":
                        if (map.get(keys).get(j).trim().equalsIgnoreCase("yes")) {
                            card.setHasChip(true);
                        } else {
                            card.setHasChip(false);
                        }
                        break;
                    case "num_cards_issued":
                        card.setNumCardsIssued(Integer.parseInt(map.get(keys).get(j).trim()));
                        break;
                    case "credit_limit":
                        card.setCreditLimit(Integer.parseInt(map.get(keys).get(j).trim().replace("$", "")));
                        break;
                    case "acct_open_date":
                        card.setAcctOpenDate(map.get(keys).get(j).trim());
                        break;
                    case "year_pin_last_changed":
                        card.setYearPinLastChanged(Integer.parseInt(map.get(keys).get(j).trim()));
                        break;
                    case "card_on_dark_web":
                        if (map.get(keys).get(j).trim().equalsIgnoreCase("yes")) {
                            card.setCardonDarkWeb(true);
                        } else {
                            card.setCardonDarkWeb(false);
                        }
                        cards.add(card);
                        break;
                }
            }
            PreparedStatement st = conn.prepareStatement(
                    "INSERT INTO cards (" +
                            "id, client_id, card_brand, card_type, card_number, expires, " +
                            "cvv, has_chip, num_cards_issued, credit_limit, " +
                            "acct_open_date, year_pin_last_changed, card_on_dark_web" +
                            ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
            );
            st.setInt(1, card.getId());
            st.setInt(2, card.getClientId());
            st.setString(3, card.getCardBrand());
            st.setString(4, card.getCardType());
            st.setLong(5, card.getCardNumber());
            st.setString(6, card.getExpires());
            st.setInt(7, card.getCvv());
            st.setBoolean(8, card.isHasChip());
            st.setInt(9, card.getNumCardsIssued());
            st.setInt(10, card.getCreditLimit());
            st.setString(11, card.getAcctOpenDate());
            st.setInt(12, card.getYearPinLastChanged());
            st.setBoolean(13, card.isCardonDarkWeb());

            st.executeUpdate();
            st.close();
        }
        System.out.println("Cards: " + cards.getCards().get(0));
        System.out.println(cards.getCards().stream().filter(Card::isHasChip).count());*/

    }
}
