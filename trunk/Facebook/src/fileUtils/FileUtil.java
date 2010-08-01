package fileUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: shreevats
 * Date: Jul 31, 2010
 * Time: 6:12:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class FileUtil {
    public static void loadFile(String fileName, List<String> lines) {
        lines.clear();
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line = null;
            while((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
