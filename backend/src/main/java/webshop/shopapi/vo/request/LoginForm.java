package webshop.shopapi.vo.request;

import com.sun.istack.NotNull;
import lombok.Data;

/*import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;*/

/**
 * Created By Zhu Lin on 1/1/2019.
 */
@Data
public class LoginForm {
    @NotNull
    private String username;
    @NotNull
    private String password;
}
