package PlayGround;

import java.io.IOException;

public class ContractTimeHasNotExpiredException extends IOException {

    public ContractTimeHasNotExpiredException( String msg ){
        super(msg);
    }
}
