package TrelloAPI;

public class Label {
    private String id;
    private String idBoard;
    private String name;


    private String color = "lime";
    private String key = "f35d4a9ecf58bff92a21516187c621d1";
    private String token = "807a8c559520b842ab8d14eb6b123deac4676b9d8fdefc0bd0a93796e7930b45";

    Label(String name, String color, String idBoard){
        this.name = name;
        this.color = color;
        this.idBoard = idBoard;
    }
    public Label(String name, String idBoard){
        this.name = name;
        this.idBoard = idBoard;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setIdBoard(String idBoard) {
        this.idBoard = idBoard;
    }

    public String getKey() {
        return key;
    }

    public String getToken(){
        return token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }
}
