package po;


import java.io.Serializable;
import lombok.Data;

@Data
public class CarsVo implements Serializable {
    private Integer carid;

    private String name;

    private Integer factoryid;

    private Integer year;

    private Integer id;

    private String manufactory;

    private String address;

    private static final long serialVersionUID = 1L;
}