package facebook;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;

/**
 * Created by IntelliJ IDEA.
 * User: shreevats
 * Date: Jul 31, 2010
 * Time: 6:12:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class FacebookConnectionManager {

    /**
     * an instance of facebook connection
     */
    private FacebookClient facebookClient;

    public FacebookConnectionManager(String ACCESS_TOKEN){
        facebookClient = new DefaultFacebookClient(ACCESS_TOKEN);
    }

    public FacebookClient getFacebookClient() {
        return facebookClient;
    }

    public void setFacebookClient(FacebookClient facebookClient) {
        this.facebookClient = facebookClient;
    }

}
