package TrelloAPI;

import java.util.Date;

public class Card {
    private String name;
    private String id;
    private String desc;
    private String idList;
    private Date due;
    private String idBoard;

    public String getId() { return id; }

    public Card(String name, String desc, String idList){
        this.name = name;
        this.idList = idList;
        this.desc = desc;
    }
}
