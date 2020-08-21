package po;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class ModeTest implements Serializable {
    private Integer id;

    private String name;

    private Integer fid;

    private Integer code;

    private Date birthday;

    private static final long serialVersionUID = 1L;
}