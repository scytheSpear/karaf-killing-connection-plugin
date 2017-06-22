package com.testing.malicious_disconn_command;

import org.apache.karaf.shell.api.action.Action;
import org.apache.karaf.shell.api.action.Argument;
import org.apache.karaf.shell.api.action.Command;
import org.apache.karaf.shell.api.action.Option;
import org.apache.karaf.shell.api.action.lifecycle.Service;

@Command(scope = "disconn", name = "start", description = "check")
@Service
public class Start implements Action {

    @Option(name = "-o", aliases = {"--option"}, description = "An option to the command", required = false, multiValued = false)
    private String option;

    @Argument(index = 0, name = "time inteval", description = "time inteval for checking malicious connections", required = true, multiValued = false)
    private int argument;

    static Task tk = new Task();

    @Override
    public Object execute() throws Exception {
        System.out.println("Executing command disconn");
        System.out.println("Option: " + option);
        System.out.println("Argument: " + argument);
//         if ("s".equals(option)){
        System.out.println("Bundle started");
        tk.start(argument * 1000);
//         }
//         else if ("a".equals(option))
//         {
//             System.out.println("Bundle aborded");
//                tk.stop();
//         }

        return null;
    }
}
