package prototype;

public class Sensor extends Prototype {

    private int ID;

    private String name;
    private String nickname;

    private String version;
    private String wifiID;
    private String wifiPass;

    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getWifiID() {
        return wifiID;
    }

    public void setWifiID(String wifiID) {
        this.wifiID = wifiID;
    }

    public String getWifiPass() {
        return wifiPass;
    }

    public void setWifiPass(String wifiPass) {
        this.wifiPass = wifiPass;
    }

//    @Override
//    public Prototype clone() throws CloneNotSupportedException {
//        return (Sensor)super.clone();
//    }


}
