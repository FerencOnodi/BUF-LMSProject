/**
 * Created by vajni on 2017.04.25..
 */
public enum DataBaseEnums {

    URL("jdbc:mysql://localhost:3306/LMS"), USER("root"), PASSWORD("@StudenT12345");

    public String dbData;

    DataBaseEnums(String dbData){
        this.dbData = dbData;
    }
}
