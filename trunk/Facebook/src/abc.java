/**
 * Created by IntelliJ IDEA.
 * User: shreevats
 * Date: Jul 30, 2010
 * Time: 10:44:41 PM
 * To change this template use File | Settings | File Templates.
 */


import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.FacebookException;
import com.restfb.types.User;

public class abc {


    public static void main(String args[]){
        String MY_ACCESS_TOKEN = "2227470867|2.Cf6_k7ENDjpC_cRUL1zpqw__.3600.1280620800-100001447627756|wvFOdX2bGLR2SGJvvXiH3YJPsEQ.";


        FacebookClient facebookClient = new DefaultFacebookClient(MY_ACCESS_TOKEN);
        User user = null;
        try {
            user = facebookClient.fetchObject("100000141684144", User.class);
            System.out.println("name: "+user.getName());
            try{
            System.out.println(""+user.getRelationshipStatus());
            }catch(NullPointerException e){
                //
            }
            System.out.println("ID: "+user.getId());
            try{
            System.out.println(""+user.getGender());
            }catch(NullPointerException e){
                //
            }

            try{
            System.out.println(""+user.getEmail());
            }catch(NullPointerException e){

            }

            try{
            System.out.println(""+user.getLocation());
            }catch(NullPointerException e){

            }
        } catch (FacebookException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }



    }


}
