package facebook;

import com.restfb.FacebookClient;
import com.restfb.FacebookException;
import com.restfb.types.User;
import fileUtils.FileUtil;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.helper.CLI;
import org.apache.commons.cli.helper.CommandLineHelper;
import org.apache.commons.cli.helper.Option;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: shreevats
 * Date: Jul 31, 2010
 * Time: 6:03:07 PM
 * To change this template use File | Settings | File Templates.
 *
 * Front end of the Crawler
 */
@CLI({
        @Option(opt = "h", longOpt="help", description = "This help"),
        @Option(opt = "k", longOpt = "access-key", description = "Access key for the API"),
        @Option(opt = "o", longOpt = "output-filename", description = "Output file name"),
//    @Option(opt = "p", longOpt = "password", description = "password for authentication"),
//    @Option(opt = "al", longOpt = "account-list", description = "file containing usernames and passwords"),
        @Option(opt = "uc", longOpt = "user-crawl", description = "user-id to crawl"),
        @Option(opt = "ul", longOpt = "user-list", description = "File with list of user-ids to crawl")
})
public class Crawler {

    private FacebookConnectionManager connectionManager = null;
    private PrintStream outputStream = null;
    private CommandLineHelper cmdHelper = null;

    public static void main(String [] args) {
        Crawler crawler = new Crawler();
        initializeCrawler(crawler, args);
        crawler.crawl();
    }

    private static void initializeCrawler(Crawler crawler, String[] args) {
        try {
            CommandLineHelper cmdHelper = new CommandLineHelper(Crawler.class);
            cmdHelper.parse(args);
            crawler.setCmdHelper(cmdHelper);
            CommandLine cli = cmdHelper.getParsedCmdLine();
            if(args.length == 0 || cli.hasOption("h")) {
                cmdHelper.displayHelp();
                return;
            }
            FacebookConnectionManager connectionManager = null;
            if(cli.hasOption("k")) {

                String ACCESS_KEY = (String)cmdHelper.getOptionValue("k");
                connectionManager = new FacebookConnectionManager(ACCESS_KEY);
            } else throw new Exception("Must provide -k argument");
            crawler.setConnectionManager(connectionManager);

            PrintStream output = System.out;
            output = new PrintStream(new FileOutputStream("OutPut.txt"));
//            if(cli.hasOption("o")) {
//                output = new PrintStream(new FileOutputStream((String)cmdHelper.getOptionValue("o")));
//            }
            crawler.setOutputStream(output);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void crawl() {
        if(crawlUsers());
        outputStream.close();
    }

    private boolean crawlUsers() {
        CommandLine cli = cmdHelper.getParsedCmdLine();
        List<String> usersToCrawl = new ArrayList<String>();
        if(cli.hasOption("uc")) usersToCrawl.add((String)cmdHelper.getOptionValue("uc"));
        else if(cli.hasOption("ul")){
            String fileName = (String)cmdHelper.getOptionValue("ul");
            FileUtil.loadFile("UserIDs", usersToCrawl);
        }
        else return false;
        // Note: This is not efficient. Substitute later with thread pools.
        for(String userID : usersToCrawl) {
            FacebookClient facebookclient = connectionManager.getFacebookClient();
            UserInfo info = getUserInfo(userID);
            info.dump(outputStream);
        }
        return true;
    }

    /**
     * This method extracts all the information from the user and returns it.
     * @param userID The user ID as registered with Facebook
     * @return User Information in an object.
     */
    private UserInfo getUserInfo(String userID) {
        User user = null;
        try {
            user = connectionManager.getFacebookClient().fetchObject(userID, User.class);
        } catch (FacebookException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        UserInfo userInfo = new UserInfo(user);
        return userInfo;
    }

    public void setConnectionManager(FacebookConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    public PrintStream getOutputStream() {
        return outputStream;
    }

    public void setOutputStream(PrintStream outputStream) {
        this.outputStream = outputStream;
    }

    public CommandLineHelper getCmdHelper() {
        return cmdHelper;
    }

    public void setCmdHelper(CommandLineHelper cmdHelper) {
        this.cmdHelper = cmdHelper;
    }
}
