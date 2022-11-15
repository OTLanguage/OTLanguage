package module.download;

import bin.apply.Repository;
import bin.apply.sys.item.SystemSetting;
import bin.apply.sys.run.FilePath;
import bin.apply.sys.run.ForceQuit;
import bin.apply.sys.run.Sleep;
import bin.apply.sys.run.TryCatch;
import bin.define.method.DefineMethod;
import bin.orign.console.normal.*;
import bin.orign.console.priority.PriorityPrint;
import bin.orign.console.priority.PriorityPrintSpace;
import bin.orign.console.priority.PriorityPrintTap;
import bin.orign.console.priority.PriorityPrintln;
import bin.orign.loop.If;
import bin.orign.loop.While;
import bin.orign.math.random.*;
import bin.orign.variable.CreateList;
import bin.orign.variable.CreateMap;
import bin.orign.variable.CreateOrigin;
import bin.orign.variable.CreateSet;
import bin.string.*;
import bin.string.list.ListAdd;
import bin.string.list.ListContains;
import bin.string.list.ListRemove;
import bin.string.list.ListRetain;
import bin.token.LoopToken;
import cos.poison.controller.HttpMethod;
import cos.poison.setting.PoisonCreate;
import cos.poison.setting.PoisonMethod;
import cos.poison.setting.PoisonStart;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static bin.apply.Repository.*;
import static bin.apply.sys.item.Separator.*;
import static bin.apply.sys.item.SystemSetting.*;
import static bin.token.ConsoleToken.*;
import static bin.token.LoopToken.*;
import static bin.token.StringToken.*;
import static bin.token.VariableToken.FILE;
import static bin.token.VariableToken.STRING_VARIABLE;
import static bin.token.cal.NumberToken.*;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class MakeGitTest {
    public MakeGitTest() {
        clear();
        start1();
        new MakeGitTest("origin", "src/main/java/bin");
        clear();
        start2();
        new MakeGitTest("poison", "src/main/java/cos/poison");
    }

    private static void clear() {
        list.clear();
        priorityStartWorksV3.clear();
        startWorksV3.clear();
        returnWorksV3.clear();
    }

    private static final List<File> list = new ArrayList<>();
    private void listFile(File file) {
        for (File cpFile : Objects.requireNonNull(file.listFiles())) {
            if (cpFile.isFile()) list.add(cpFile);
            else listFile(cpFile);
        }
    }

    String COMPULSION = "compulsion";   // 강제
    String ALTERATION = "alteration";   // 변경
    String OPERATE = "operate";         // 동작

    // name : poison
    private MakeGitTest(String name, String fileName) {
        listFile(new File(fileName));
        // User/name/Documents/GitHub/module/poison
        String namePath = SEPARATOR_HOME + "/Documents/GitHub/module/" + name;
        File file = new File(namePath);
        file.mkdirs();
        try (BufferedWriter br = new BufferedWriter(new FileWriter(namePath + "/system.otls", false))) {
            if (!priorityStartWorksV3.isEmpty()) {
                try (var output = new ObjectOutputStream(new FileOutputStream(namePath + "/" + COMPULSION + MODULE_EXTENSION))) {
                    output.writeObject(priorityStartWorksV3);
                } catch (IOException ignored) {}
                try (var output = new ObjectOutputStream(new FileOutputStream(COMPULSION_PATH + "/" + name + ".otlm"))) {
                    output.writeObject(priorityStartWorksV3);
                } catch (IOException ignored) {}
                br.write(COMPULSION);
                br.newLine();
            }

            if (!returnWorksV3.isEmpty()) {
                try (var output = new ObjectOutputStream(new FileOutputStream(namePath + "/" + ALTERATION + MODULE_EXTENSION))) {
                    output.writeObject(returnWorksV3);
                } catch (IOException ignored) {}
                try (var output = new ObjectOutputStream(new FileOutputStream(ALTERATION_PATH + "/" + name + ".otlm"))) {
                    output.writeObject(returnWorksV3);
                } catch (IOException ignored) {}

                br.write(ALTERATION);
                br.newLine();
            }

            if (!startWorksV3.isEmpty()) {
                try (var output = new ObjectOutputStream(new FileOutputStream(namePath + "/" + OPERATE + MODULE_EXTENSION))) {
                    output.writeObject(startWorksV3);
                } catch (IOException ignored) {}
                try (var output = new ObjectOutputStream(new FileOutputStream(OPERATE_PATH + "/" + name + ".otlm"))) {
                    output.writeObject(startWorksV3);
                } catch (IOException ignored) {}
                br.write(OPERATE);
                br.newLine();
            }

            for (File f : list) {
                int start = (System.getProperty("user.home") + "/Documents/Java/OTLanguage/src/main/java/").length();
                int end = f.getAbsolutePath().length() - ".java".length();
                String value = f.getAbsolutePath().substring(start, end).replace("/", "~");
                br.newLine();
                br.write(value.replace(".", "~"));

                String klassName = file.getAbsolutePath() + "/" + f.getName().substring(0, f.getName().length()-".java".length()) + ".class";
                copy(value.replace("~", SEPARATOR_FILE), klassName);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void copy(String klassPath, String klassName) throws IOException {
        String path = "out/production/classes/" + klassPath + ".class";
        Files.copy(new File(path).toPath(), new File(klassName).toPath(), REPLACE_EXISTING);
    }

    private static void start1() {
        String WHITE = LoopToken.WHITE.replace("\\", "");
        String IF = LoopToken.IF.replace("\\", "");

        priorityCreateStartWorks(FORCE_QUIT, "", new ForceQuit(0));
        priorityCreateStartWorks(PRIORITY_PRINT, "", new PriorityPrint(1));
        priorityCreateStartWorks(PRIORITY_PRINTLN, "", new PriorityPrintln(1));
        priorityCreateStartWorks(PRIORITY_PRINT_TAP, "", new PriorityPrintTap(1));
        priorityCreateStartWorks(PRIORITY_PRINT_SPACE, "", new PriorityPrintSpace(1));
        priorityCreateStartWorks(TRY_CATCH, "", new TryCatch(1));

        CreateOrigin createOrigin = new CreateOrigin();
        CreateSet createSet = new CreateSet();
        CreateList createList = new CreateList();
        CreateMap createMap = new CreateMap();
        ORIGIN_LIST.forEach(v -> createStartWorks(v, "", createOrigin));
        SET_LIST.forEach(v -> createStartWorks(v, "", createSet));
        LIST_LIST.forEach(v -> createStartWorks(v, "", createList));
        MAP_LIST.forEach(v -> createStartWorks(v, "", createMap));
        createStartWorks(PRINT, "", new Print(1));
        createStartWorks(PRINTLN, "", new Println(1));
        createStartWorks(PRINT_SPACE, "", new PrintSpace(1));
        createStartWorks(PRINT_TAP, "", new PrintTap(1));
        createStartWorks(SLEEP, "", new Sleep(1));
        createStartWorks(FILE, "", new FilePath(1));
        createStartWorks(WHITE, "", new While(1));
        createStartWorks(IF, "", new If(1));
        createStartWorks(METHOD, "", new DefineMethod(1));


        createReturnWorks(RANDOM_BOOL, "", new RandomBoolean(1));
        createReturnWorks(RANDOM_DOUBLE, "", new RandomDouble(1, 2));
        createReturnWorks(RANDOM_FLOAT, "", new RandomFloat(1, 2));
        createReturnWorks(RANDOM_INTEGER, "", new RandomInteger(1, 2));
        createReturnWorks(RANDOM_LONG, "", new RandomLong(1, 2));
        createReturnWorks(SCANNER, "", new Scanner(0));
        createReturnWorks(STRING_VARIABLE, JOIN, new Join(2));
        createReturnWorks(STRING_VARIABLE, SPLIT, new Split(2));
        createReturnWorks(STRING_VARIABLE, SPLIT_REGULAR, new SplitRegular(2));
        createReturnWorks(STRING_VARIABLE, CONTAINS_S, new Contains(2));
        createReturnWorks(STRING_VARIABLE, EQUALS_S, new Equals(2));
        LIST_LIST.forEach(v -> {
            createStartWorks(v, ADD_ALL, new ListAdd(v, 2));
            createStartWorks(v, RETAIN_ALL, new ListRetain(v, 2));
            createStartWorks(v, REMOVE_ALL, new ListRemove(v, 2));
            createReturnWorks(v, CONTAINS_ALL, new ListContains(v, 2));
        });
    }

    private static void start2() {
        createStartWorks(POISON, "", new PoisonCreate(1, 2));
        createStartWorks(POISON, POISON_START, new PoisonStart(0));
        createStartWorks(POISON, POISON_POST, new PoisonMethod(HttpMethod.POST));
        createStartWorks(POISON, POISON_GET, new PoisonMethod(HttpMethod.GET));
    }
}
