public class Passenger {
    private int pclass;
    private String survived;
    private String name;
    private String sex;
    private float age;
    private int siblingsAboard;
    private int parentsChildrenAboard;
    private String ticket;
    private float fare;
    private String cabin;
    private String embarked;
    private String boat;
    private String body;
    private String homeDist;


    public int getpclass() {
        return pclass;
    }

    public String getSurvived() {
        return survived;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public float getAge() {
        return age;
    }

    public int getSibsp() {
        return siblingsAboard;
    }

    public int getParch() {
        return parentsChildrenAboard;
    }

    public String getTicket() {
        return ticket;
    }

    public float getFare() {
        return fare;
    }

    public String getCabin() {
        return cabin;
    }

    public String getEmbarked() {
        return embarked;
    }

    public String getBoat() {
        return boat;
    }

    public String getBody() {
        return body;
    }

    public String getHomeDist() {
        return homeDist;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "pClass=" + pclass +
                ", survived=" + survived +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", siblingsAboard=" + siblingsAboard +
                ", parentsChildrenAboard=" + parentsChildrenAboard +
                ", ticket='" + ticket + '\'' +
                ", fare=" + fare +
                ", cabin='" + cabin + '\'' +
                ", embarked='" + embarked + '\'' +
                ", boat='" + boat + '\'' +
                ", body=" + body +
                ", homeDist='" + homeDist + '\'' +
                '}';
    }
}
