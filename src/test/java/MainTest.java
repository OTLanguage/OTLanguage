import bin.apply.Setting;
import bin.apply.sys.make.ChangeHangle;
import bin.apply.sys.make.StartLine;
import bin.exception.FileException;
import bin.token.LoopToken;
import etc.gui.replace.*;
import etc.gui.start.*;
import module.download.MakeGitTest;

import java.awt.*;
import java.io.IOException;

import static bin.apply.Controller.br;
import static bin.apply.Controller.bw;
import static bin.apply.sys.item.Separator.*;
import static bin.apply.sys.item.SystemSetting.createReturnWorks;
import static bin.apply.sys.item.SystemSetting.createStartWorks;
import static etc.gui.setting.RepositoryTest.*;

public class MainTest implements LoopToken, ChangeHangle {
    public static void main(String[] args) throws AWTException, IOException {
        StartLine.developmentMode = true;
//        Taskbar.getTaskbar().setIconImage(Toolkit.getDefaultToolkit().getImage(sb.toString()));
//        Taskbar.getTaskbar().setIconImage(Toolkit.getDefaultToolkit().getImage("image/icon.png"));
//        Robot robot = new Robot();
//        JFrame frame = new JFrame("test");

        new MakeGitTest();
        new Setting();

        createStartWorks(GUI, SET_COLUMNS, new OSetColumnsTest(2));

        createReturnWorks(GUI, GET_COLUMNS, new OGetColumnsTest(1));

        try {
            new Main(new String[]{SEPARATOR_HOME, "hello.otl"});

//            new Main(new String[]{SEPARATOR_HOME, "icon.otlm"});

//            new Main(new String[]{SEPARATOR_HOME, "test/set_test.otl"});
//            new Main(new String[]{SEPARATOR_HOME, "test/list_test.otl"});
//            new Main(new String[]{SEPARATOR_HOME, "test/map_test.otl"});
        } catch (FileException e) {
            new FileException().printErrorMessage(e, Setting.mainPath);
        } finally {try {br.close(); bw.close();} catch (IOException ignored) {}}
    }
}
